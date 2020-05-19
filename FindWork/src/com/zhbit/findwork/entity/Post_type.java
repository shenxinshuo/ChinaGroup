package com.zhbit.findwork.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 岗位类型类
 * @author 陈宇枫
 *
 */

public class Post_type {

	private int PTid;
	private String PTname;
	private String Comment;
	private int delete_flag;
	private Date create_at;
	private Date update_at;
	private List<Post> posts = new ArrayList<Post>();
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public int getPTid() {
		return PTid;
	}
	public void setPTid(int pTid) {
		PTid = pTid;
	}
	public String getPTname() {
		return PTname;
	}
	public void setPTname(String pTname) {
		PTname = pTname;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public int getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	public Date getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}
	
}
