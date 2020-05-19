package com.zhbit.findwork.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Post;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.service.Post_typeService;

public class PostTypeAction extends ActionSupport{

	private Post_typeService post_typeService;
	private List<Post_type> pts;
	private Post_type pt;
	
	//获取所有岗位类型
	public String getAllPtypes(){
		
		pts = post_typeService.getAllPost_type();
		System.out.println(pts.size());
		pt = pts.get(0);
		System.out.println(pt.getPTname());
		for(int i=0; i<pts.get(0).getPosts().size(); i++){
			
			System.out.println(pts.get(0).getPosts().get(i).getPname());
			
		}
		return "showAllPtypes";
		
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

	public Post_type getPt() {
		return pt;
	}

	public void setPt(Post_type pt) {
		this.pt = pt;
	}
	
	

}
