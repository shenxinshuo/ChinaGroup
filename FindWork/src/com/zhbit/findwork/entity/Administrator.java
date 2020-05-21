package com.zhbit.findwork.entity;

import java.util.Date;

/**
 * 管理员类
 * @author 陈宇枫
 *
 */
public class Administrator {

	private int ADid;
	private int Rid;
	private String password;
	private String account;
	private String Comment;
	private int delete_flag;
	private Date create_at;
	private Date update_at;
	private Role role;            //与角色类建立多对一关系
	
	public int getADid() {
		return ADid;
	}
	public void setADid(int aDid) {
		ADid = aDid;
	}
	public int getRid() {
		return Rid;
	}
	public void setRid(int rid) {
		Rid = rid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
