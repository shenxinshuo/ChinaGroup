package com.zhbit.findwork.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.service.BusinessService;
import com.zhbit.findwork.service.Post_typeService;

public class BusinessLoginAction extends ActionSupport{
	
	private Business business;
	private List<Post_type> pts;
	private BusinessService businessService;
	private Post_typeService post_typeService;
	
	public void validateLogin(){
		
		System.out.println(business.getName()+business.getPassword());
		//判断用户名是否为空
		if(business.getName()==null||business.getName().equals("")){
			this.addFieldError("businessName", "企业账号不能为空");
			System.out.println("0");
		}else if(business.getPassword()==null || business.getPassword().equals("")){
			this.addFieldError("businessPassword", "密码不能为空");
		}else if(businessService.login(business.getName(), business.getPassword()) == null){
			this.addFieldError("businessName", "企业账号或密码错误");
			this.addFieldError("businessPassword", "企业账号或密码错误");
		}
	}

	
	public String login(){
		
		Business b = businessService.login(business.getName(), business.getPassword());
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_BUSI", b);
		pts = post_typeService.getAllPost_type();
		return "login";
		
	}
	
	public String logout(){
		
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_BUSI",null);
		
		return "logout";
		
	}
	
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public BusinessService getBusinessService() {
		return businessService;
	}
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}


	public List<Post_type> getPts() {
		return pts;
	}


	public void setPts(List<Post_type> pts) {
		this.pts = pts;
	}


	public Post_typeService getPost_typeService() {
		return post_typeService;
	}


	public void setPost_typeService(Post_typeService post_typeService) {
		this.post_typeService = post_typeService;
	}

}
