package com.zhbit.findwork.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertisement;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.service.AdvertisementService;
import com.zhbit.findwork.service.BusinessService;
import com.zhbit.findwork.service.Post_typeService;

public class BusinessLoginAction extends ActionSupport{
	
	private Business business;
	private List<Post_type> pts;
	private BusinessService businessService;
	private Post_typeService post_typeService;
	private AdvertisementService  advertisementService;
	private String url[]= new String [6];
	public AdvertisementService getAdvertisementService() {
		return advertisementService;
	}


	public void setAdvertisementService(AdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}


	public String[] getUrl() {
		return url;
	}


	public void setUrl(String[] url) {
		this.url = url;
	}


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
		ac.getSession().put("LOGINED_USER", b);
		ac.getSession().put("LOGINED_ROLE", 2);
		business = b;//将有id的b赋值得business，重定向到action时用到
		pts = post_typeService.getAllPost_type();
		List<Advertisement> ads=advertisementService.getAllAdvertisements();
		for(int i=0;i<ads.size();i++){
			url[ads.get(i).getPosition()]=ads.get(i).getUrl();
		}
		return "login";
		
	}
	
	public String logout(){
		
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_USER",null);
		ac.getSession().put("LOGINED_ROLE", null);
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
