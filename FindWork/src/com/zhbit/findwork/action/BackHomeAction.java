package com.zhbit.findwork.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertisement;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.service.AdvertisementService;
import com.zhbit.findwork.service.Post_typeService;

public class BackHomeAction extends ActionSupport{

	private Post_typeService post_typeService;
	private List<Post_type> pts; 
	private AdvertisementService  advertisementService;
	private String url[]= new String [6];

	public String[] getUrl() {
		return url;
	}

	public void setUrl(String[] url) {
		this.url = url;
	}

	public AdvertisementService getAdvertisementService() {
		return advertisementService;
	}

	public void setAdvertisementService(AdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}
	
	public void getAdvertisementURL(){
		List<Advertisement> ads=advertisementService.getAllAdvertisements();
		for(int i=0;i<ads.size();i++){
			url[ads.get(i).getPosition()]=ads.get(i).getUrl();
		}
	}
	public String backHome(){
		getAdvertisementURL();
		pts = post_typeService.getAllPost_type();
		return "backHome";
		
	}
	
	public String noLogin(){
		getAdvertisementURL();
		pts = post_typeService.getAllPost_type();
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_USER", null);
		return "noLogin";
		
	}
	
	public String logoutToLogin(){
		
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_TOURIST", null);
		return "tologin";
		
	}
	
	public String logoutToRegis(){
	
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_TOURIST", null);
		return "toregis";
		
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
