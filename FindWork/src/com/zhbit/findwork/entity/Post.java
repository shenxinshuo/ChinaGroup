package com.zhbit.findwork.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Post {
	
	private int Pid;
	private String Pname;
	private String Comment;
	private int delete_flag;
	private Date create_at;
	private Date update_at;
	private Post_type ptype;
	private Set<Advertise> advertises = new HashSet<Advertise>();

	
	
	public Post_type getPtype() {
		return ptype;
	}
	public void setPtype(Post_type ptype) {
		this.ptype = ptype;
	}
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
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
	public Set<Advertise> getAdvertises() {
		return advertises;
	}
	public void setAdvertises(Set<Advertise> advertises) {
		this.advertises = advertises;
	}
	
	
}
