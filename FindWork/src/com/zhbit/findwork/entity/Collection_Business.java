package com.zhbit.findwork.entity;

import java.util.Date;
import java.util.List;

/**
 * 收藏中心（企业）类
 * 
 * @author 王德略
 *
 */
public class Collection_Business {
	private int id;
	private User user; //用户多对一
	private Business business; //和企业多对一
	private int delete_flag = 0;//删除标识   0：正常  1：已删除
	private String comment;		//
	private Date create_at;		//创建时间
	private Date update_at;		//更新时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public int getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
