package com.zhbit.findwork.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.service.Post_typeService;

public class BackHomeAction extends ActionSupport{

	private Post_typeService post_typeService;
	private List<Post_type> pts; 

	public String backHome(){
		
		pts = post_typeService.getAllPost_type();
		return "backHome";
		
	}
	
	public String noLogin(){
		
		pts = post_typeService.getAllPost_type();
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_TOURIST", 1);
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
