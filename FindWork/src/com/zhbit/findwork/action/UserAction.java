package com.zhbit.findwork.action;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.RoleService;
import com.zhbit.findwork.service.UserService;

public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService;


	private String message;				//用于返回信息给页面，提示用户
	private String errorMessage;		//显示异常信息

	
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
}
