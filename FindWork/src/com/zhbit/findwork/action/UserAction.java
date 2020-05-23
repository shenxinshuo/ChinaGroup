package com.zhbit.findwork.action;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.entity.UserBirthday;
import com.zhbit.findwork.service.CvService;
import com.zhbit.findwork.service.Post_typeService;
import com.zhbit.findwork.service.RoleService;
import com.zhbit.findwork.service.UserService;
/**
 * 用户action类
 * 
 * @author 王德略
 *
 */
public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService;
	private Post_typeService post_typeService;
	private String message;				//用于返回信息给页面，提示用户
	private String errorMessage;		//显示异常信息
	private String spassword;           //第二次输入的密码
	private UserBirthday ubirthday;     //注册输入的年 月 日信息
	private List<Post_type> pts;        //岗位类型及岗位
	
	private File Header; //头像
	private String HeaderFileName;//文件名
	private String HeaderContentType;//文件类型

	private String repwd;//修改密码
	private String repwd2;//注销密码
	private String deleteMessage;//注销提示
	
	private String newpwd;
	private String confirmpwd;
	//简历
	private CvService cvService;
	private List<Cv> cvs;
	
	private RoleService roleService;
	
	

	/**
	 * 个人中心 注销用户
	 * @return
	 */
	public String delete(){
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		if(repwd2==null){
			deleteMessage="请再次确认注销，确认请输入密码";
			repwd2="";
			return "showSecurity";//返回注销页面
		}
		if(repwd2.equals("")){
			deleteMessage="密码不能为空";
			return "showSecurity";
		}
		if(userService.getUserByNameAndPassword(user.getName(), repwd2)==null){
			deleteMessage="密码错误";
			return "showSecurity";
		}
		else{
			userService.deleteUserByID(user.getId());
			return "delete";
		}
		
	}
	
	//显示用户的简历
	public String showCvList(){
		//假设当前用户是登录用户
		/*User user =userService.getUserByID(1);*/
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		cvs=cvService.getCvListByUserId(user.getId());
		return "showCvList";
	}
	//退出
	public String logout(){
		  
		  ActionContext ac = ActionContext.getContext();
		  ac.getSession().put("LOGINED_USER",null);
		
		  ac.getSession().put("LOGINED_ROLE", null);
		  return "logout";
		  
		 }

	/**
	 * 个人中心 显示我的信息
	 * @return
	 */
	public String showMyInformation(){
		//获取当前用户
		user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		if(user==null)
			return ERROR;
		else{
			return "showMyInformation";
		}
	}

	//我的信息 验证
		public void validateSaveMyInformation(){
			//判断电话号码格式是否正确的正则表达式
			String tel = "((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";		
			//判断邮箱正确的正则表达式
			String em = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";				
			System.out.println(user.getBirthday());
			if(user.getName()==null||user.getName().equals("")){
				this.addFieldError("userName", "用户名不能为空");
			}
			if(!user.getEmail().matches(em)){
				this.addFieldError("userEmail", "邮箱格式不正确");
			}
			if(!user.getTelephone().matches(tel)){
				this.addFieldError("userTelephone", "手机号码格式不正确");
			}
			if(user.getBirthday()==null||user.getBirthday().equals("")){
				this.addFieldError("userBirthday", "时间格式不正确，例如2020-02-02");
			}
			if(user.getAddress()==null||user.getAddress().equals("")){
				this.addFieldError("userAddress", "地址不能为空");
			}
			
		}

		/**
		 *个人中心 保存我的信息
		 * @return
		 */
		public String saveMyInformation(){	
			Role role= user.getRole();
			user.setRole(role);
			boolean flag= userService.updateUser(user);	
			
			if(flag){
				user=userService.getUserByID(user.getId());
				ActionContext ac = ActionContext.getContext();
				  ac.getSession().put("LOGINED_USER", user);
				message="保存成功";
				return "saveMyInformation";
			}	
			else{
				errorMessage="用户名已经存在";
				return "input";
			} 
				
		}

	/**
	 *用户注册信息验证
	 * @return
	 */
	public void validateRegister(){
		
		String em = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		
		//判断用户名是否为空
		if(user.getName()==null||user.getName().equals("")){
			this.addFieldError("userName", "用户名不能为空");
			System.out.println("0");
		}else{
			//判断用户名是否被使用
			if(userService.getUserByName(user.getName()) != null){
				this.addFieldError("userName", "该用户名已被使用");
				System.out.println("1");
			}
		}
		
		//判断邮箱地址格式是否正确
		if(!user.getEmail().matches(em)){
			this.addFieldError("userEmail", "邮箱格式不正确");
		}
		
		//判断两次密码是否相同
		if(user.getPassword() == null || user.getPassword().equals("")){
			this.addFieldError("userPassword", "密码为空");
			System.out.println("2");
		}else if(user.getPassword().length() <8 && user.getPassword().length() >18){
			this.addFieldError("userPassword", "密码长度应在8-16位数字和字母组合");
			System.out.println("3");
		}
		if(spassword == null || spassword.equals("")){
			this.addFieldError("sPassword", "确认密码为空");
			System.out.println("4");
		}else if(!spassword.equals(user.getPassword())){
			this.addFieldError("userPassword", "密码与确认密码不一致");
			this.addFieldError("sPassword", "密码与确认密码不一致");
			System.out.println("5");
		}
		System.out.println("6");
	}
	
	/**
	 *用户注册
	 * @return
	 */
	public String register(){
		
		if(ubirthday.getByear().length() == 1){
			ubirthday.setByear(new String("0").concat(ubirthday.getByear()));
		}
		if(ubirthday.getBmonth().length() == 1){
			ubirthday.setBmonth(new String("0").concat(ubirthday.getBmonth()));
		}
		if(ubirthday.getBday().length() == 1){
			ubirthday.setBday(new String("0").concat(ubirthday.getBday()));
		}
		try {
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(ubirthday.toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Role role= roleService.getRoleByID(1);//求职者
		user.setRole(role);
		userService.addUser(user);
		return "register";
		
	}
	
	/**
	 *用户登录信息验证
	 * @return
	 */
	public void validateLogin(){
		
		//判断用户名是否为空
		if(user.getName()==null||user.getName().equals("")){
			this.addFieldError("userName", "用户名不能为空");
			System.out.println("0");
		}else if(user.getPassword()==null || user.getPassword().equals("")){
			this.addFieldError("userPassword", "密码不能为空");
		}else if(userService.getUserByNameAndPassword(user.getName(), user.getPassword()) == null){
			this.addFieldError("userName", "用户名或密码错误");
			this.addFieldError("userPassword", "用户名或密码错误");
		}
	}

	/**
	 * 登录
	 * @return
	 */	
	public String login(){
		
		User u = userService.getUserByNameAndPassword(user.getName(), user.getPassword());
		
		ActionContext ac = ActionContext.getContext();
		  ac.getSession().put("LOGINED_USER", u);
		  ac.getSession().put("LOGINED_ROLE", 1);
		System.out.println(ActionContext.getContext()
		.getSession().get("LOGINED_USER"));
		pts = post_typeService.getAllPost_type();
		return "login";
		
	}
	
	//验证上传的文件是否为空
		public void validateSaveHeader(){
			System.out.println("jhhhhhhhhhhhhhhhhhhhhhhh");
			if(HeaderFileName==null||HeaderFileName.equals("")){
				this.addFieldError("userHeader", "请选择新的头像");
			}
		}
		/**
		 *个人中心 修改我的头像
		 * @return
		 */
		public String saveHeader(){
			//建立唯一标识的路径
			//设置相对路径
			String imagePath="/upload/Header/"+
			UUID.randomUUID().toString()+
					HeaderFileName.substring(HeaderFileName.lastIndexOf("."));		
			//设置绝对路径
			String path=ServletActionContext.
					getServletContext().getRealPath(imagePath);
			
			System.out.println(path);
			//创建新的文件
			File file=new File(path);
			try {
				FileUtils.copyFile(Header, file);
				//获取当前用户
				user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
				user.setImagepath(path);//用户保存上传的相对路径
				userService.updateUser(user);
				//保存当前头像相对路径，页面获取
				message="头像保存成功";
				ActionContext.getContext().getSession().put("imagePath", ".."+imagePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return "saveHeader";

		}

		/**
		 * 个人中心 显示我的头像
		 * @return
		 */
		//展示我的头像
		public String showHeader(){
			//获取当前用户存储的图片路径
			user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
			ActionContext.getContext().getSession().put("imagePath", ".."+user.getImagepath());
			System.out.println("展示当前用户的头像");
			return "showHeader";
		}
	    public void validateSaveSecurity(){
			if(repwd.equals("")||repwd==null)
				this.addFieldError("repwd", "原密码不能为空");
			if(newpwd.equals("")||newpwd==null)
				this.addFieldError("newpwd", "新密码不能为空");
			if(confirmpwd.equals("")||confirmpwd==null)
				this.addFieldError("confirmpwd", "第二次确认密码不能为空");
			if(!confirmpwd.equals(newpwd))
				this.addFieldError("confirmpwd", "密码不一致，请重新输入");
			if(newpwd.matches("[0-9]{1,}"))
				this.addFieldError("newpwd", "密码不能是纯数字");
			if(newpwd.length()<=6)
				this.addFieldError("newpwd", "密码不能少于6位");
		}

		/**
		 * 个人中心 修改密码
		 * @return
		 */
		//修改密码
		public String saveSecurity(){
			//假设这个是当前登录用户
			User olduser=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
			User user = userService.getUserByNameAndPassword(olduser.getName(), repwd);
			//如果能通过旧密码查询到当前用户，说明密码输入正确
			if(user!=null){
				user.setPassword(newpwd);//更改当前密码
				userService.updateUser(user);//持久化
				message="密码修改成功";
				return "showSecurity";
			}
			else{//密码输入错误
				errorMessage="原密码输入错误，请重新输入";
				return "showSecurity";
			}		
		}
		
		/**
		 * 个人中心 获取头像
		 * @return
		 */
		public String readHeader(){
			System.out.println("读取头像");
			return "readHeader";
		}
		/**
		 * 个人中心 获取头像数据流
		 * @return
		 */
		public InputStream getInputStream() throws Exception{
			System.out.println("数据流读取头像");
			//获取当前用户
			user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
			System.out.println(user);
			System.out.println(user.getId());
			String path=user.getImagepath();
			System.out.println(path);
			try{
				//如果用户有头像，返回用户头像
				InputStream inputStream = new FileInputStream(path);
				return inputStream;
			}catch(Exception e){
				//用户如果之前没有头像，返回默认头像
				InputStream inputStream = new FileInputStream("D:\\a.jpg");
				return inputStream;
			}
			
			
		}
    

		public CvService getCvService() {
			return cvService;
		}

		public void setCvService(CvService cvService) {
			this.cvService = cvService;
		}

		public List<Cv> getCvs() {
			return cvs;
		}

		public void setCvs(List<Cv> cvs) {
			this.cvs = cvs;
		}
		
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public UserBirthday getUbirthday() {
		return ubirthday;
	}
	public void setUbirthday(UserBirthday ubirthday) {
		this.ubirthday = ubirthday;
	}
	public Post_typeService getPost_typeService() {
		return post_typeService;
	}
	public void setPost_typeService(Post_typeService post_typeService) {
		this.post_typeService = post_typeService;
	}
	public List<Post_type> getPts() {
		return pts;
	}
	public void setPts(List<Post_type> pts) {
		this.pts = pts;
	}
	
	public File getHeader() {
		return Header;
	}
	public void setHeader(File header) {
		Header = header;
	}
	public String getHeaderFileName() {
		return HeaderFileName;
	}
	public void setHeaderFileName(String headerFileName) {
		HeaderFileName = headerFileName;
	}
	public String getHeaderContentType() {
		return HeaderContentType;
	}
	public void setHeaderContentType(String headerContentType) {
		HeaderContentType = headerContentType;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public String getRepwd2() {
		return repwd2;
	}
	public String getDeleteMessage() {
		return deleteMessage;
	}

	public void setDeleteMessage(String deleteMessage) {
		this.deleteMessage = deleteMessage;
	}

	public void setRepwd2(String repwd2) {
		this.repwd2 = repwd2;
	}
}
