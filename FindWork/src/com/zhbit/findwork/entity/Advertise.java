package com.zhbit.findwork.entity;

import java.util.Date;

/**
 * 职位Bean类
 * 
 * @author 钦治
 *
 */
public class Advertise {
	private int id;// 职位id
	private String title;// 招聘标题
	private String post;// 招聘岗位
	private String educationBackground;// 学历
	private int lowWages;// 最低工资
	private int largeWages;// 最高工资
	private String ask;// 岗位要求
	private String wantJoyType;// 招聘类型:0全职1实习2兼职
	private Date deadline;// 截止日期
	private int deleteFlag;// 删除标识
	private String comment;// 备注
	private Date createAt; // 创建时间
	private Date updateaAt; // 修改时间
	private int check;// 是否审核
	private Business business;// 与企业类多对一关系
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getEducationBackground() {
		return educationBackground;
	}
	public void setEducationBackground(String educationBackground) {
		this.educationBackground = educationBackground;
	}
	public int getLowWages() {
		return lowWages;
	}
	public void setLowWages(int lowWages) {
		this.lowWages = lowWages;
	}
	
	public int getLargeWages() {
		return largeWages;
	}
	public void setLargeWages(int largeWages) {
		this.largeWages = largeWages;
	}
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	public String getWantJoyType() {
		return wantJoyType;
	}
	public void setWantJoyType(String wantJoyType) {
		this.wantJoyType = wantJoyType;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateaAt() {
		return updateaAt;
	}
	public void setUpdateaAt(Date updateaAt) {
		this.updateaAt = updateaAt;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public Business getBusiness() {
		return business;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	@Override
	public String toString() {
		return "Advertise [id=" + id + ", title=" + title + ", post=" + post
				+ ", educationBackground=" + educationBackground
				+ ", lowWages=" + lowWages + ", largeWages=" + largeWages
				+ ", ask=" + ask + ", wantJoyType=" + wantJoyType
				+ ", deadline=" + deadline + ", deleteFlag=" + deleteFlag
				+ ", comment=" + comment + ", createAt=" + createAt
				+ ", updateaAt=" + updateaAt + ", check=" + check
				+ ", business=" + business + "]";
	}
	
}
