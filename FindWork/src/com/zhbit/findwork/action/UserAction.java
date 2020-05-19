package com.zhbit.findwork.action;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.entity.UserBirthday;
import com.zhbit.findwork.service.Post_typeService;
import com.zhbit.findwork.service.RoleService;
import com.zhbit.findwork.service.UserService;

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
	
	/**
	 * 个人中心 显示我的信息
	 * @return
	 */
	public String show(){
		//从登录对象中获取用户，现在暂时从数据库中读取一个用户
		user=userService.getUserByID(1);
/*		Rid=user.getRole().getId();
		System.out.println(Rid+"dfaaaaaaaaaaaaaaaaaaaaaaaaaaaa");*/
		if(user==null)
			return ERROR;
		else{
			return "show";
		}
	}
	//我的信息 验证
	public void validateSave(){
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
	public String save(){	
		/*Role role = roleService.getRoleByID(Rid);//保存关联的对象
		System.out.println(role);
		user.setRole(role);*/
		boolean flag= userService.updateUser(user);		
		if(flag){
			message="保存成功";
			return "save";
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
		
	public String login(){
		
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_USER", user);
		pts = post_typeService.getAllPost_type();
		return "login";
		
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
	
	
}
