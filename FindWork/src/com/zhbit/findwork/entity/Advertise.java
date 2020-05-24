package com.zhbit.findwork.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 职位Bean类
 * 
 * @author 钦治
 *
 */
public class Advertise {
	private int id;// 职位id
	private int bid;//企业id
	private String title;// 招聘标题
	private String postName;// 招聘岗位
	private String businessName;//企业名字
	private String educationBackground;// 学历
	private int lowWages;// 最低工资
	private int largeWages;// 最高工资
	private String ask;// 岗位要求
	private String wantJoyType;// 招聘类型:0全职1实习2兼职
	private Date deadline;// 截止日期
	private int deleteFlag;// 删除标识
	private String comment;// 备注
	private Date createAt; // 创建时间
	private Date updateAt; // 修改时间
	private int check;// 是否审核 0否 1是
	private String city;//城市
	private Business business;// 与企业类多对一关系
	private Post post;			//与岗位多对一关系
	private Set<Cv> cvs = new HashSet<Cv>();//与简历多对多;
	
	
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
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
	
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
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
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
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
	public Set<Cv> getCvs() {
		return cvs;
	}
	public void setCvs(Set<Cv> cvs) {
		this.cvs = cvs;
	}
}
