package com.zhbit.findwork.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 企业Bean类
 * 
 * @author 沈鑫烁
 *
 */
public class Business {
	private int id;				//
	private String name;		//
	private String city;		//企业所在城市
	private String telephone;		//
	private String email;		//
	private String address;		//
	private String description;	//企业简介
	private String url;			//公司详情超链接
	private String license_path;//营业执照路径
	private String password;    //登录密码
	private String confirmPassword; //确认密码，跟数据库没有关系
	private int check_flag;		//审核状态	0:待审核 1：通过 -1：未通过  
	private int delete_flag = 0;//删除标识   0：正常  1：已删除
	private String comment;		//
	private Date create_at;		//
	private Date update_at;		//
	private Role role;			//与角色类建立多对一关系
	//private List<Advertise> advertises;//与招聘信息建立一对多关系
	private Set<Advertise> advertises = new HashSet<Advertise>();//与招聘信息建立一对多关系
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLicense_path() {
		return license_path;
	}
	public void setLicense_path(String license_path) {
		this.license_path = license_path;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public int getCheck_flag() {
		return check_flag;
	}
	public void setCheck_flag(int check_flag) {
		this.check_flag = check_flag;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	/*public List<Advertise> getAdvertises() {
		return advertises;
	}
	public void setAdvertises(List<Advertise> advertises) {
		this.advertises = advertises;
	}*/
	
	@Override
	public String toString() {
		return "Business [id=" + id + ", name=" + name + ", city=" + city + ", telephone=" + telephone + ", email="
				+ email + ", address=" + address + ", description=" + description + ", url=" + url + ", license_path="
				+ license_path + ", password=" + password + ", confirmPassword=" + confirmPassword + ", check_flag="
				+ check_flag + ", delete_flag=" + delete_flag + ", comment=" + comment + ", create_at=" + create_at
				+ ", update_at=" + update_at + "]";
	}
	public Set<Advertise> getAdvertises() {
		return advertises;
	}
	public void setAdvertises(Set<Advertise> advertises) {
		this.advertises = advertises;
	}
	
	
	
	
}
