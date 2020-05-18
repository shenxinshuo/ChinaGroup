package com.zhbit.findwork.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.service.BusinessService;

public class BusinessAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Business business;
	private BusinessService businessService;
	private String message;				//用于返回信息给页面，提示用户
	private String errorMessage;		//显示异常信息
	
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	public void setBusiness(Business business) {
		this.business = business;
	}
	public Business getBusiness() {
		return business;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	//注册企业表单验证
	public void validateadd() {
			if (business.getName() == null || "".equals(business.getName())) {
				addFieldError("business.name", "企业名称不能为空");
			}
			if (business.getCity() == null || "".equals(business.getCity())) {
				addFieldError("business.city", "所在城市不能为空");
			}
			if (business.getTelephone() == null || "".equals(business.getTelephone())) {
				addFieldError("business.telephone", "联系电话不能为空");
			}
			if (business.getPassword() == null || "".equals(business.getPassword())) {
				addFieldError("business.password", "登录密码不能为空");
			}
			if (business.getConfirmPassword() == null || "".equals(business.getConfirmPassword())) {
				addFieldError("business.confirmPassword", "确认密码不能为空");
			}
			if (business.getAddress() == null || "".equals(business.getAddress())) {
				addFieldError("business.address", "企业地址不能为空");
			}
			if (business.getDescription() == null || "".equals(business.getDescription())) {
				addFieldError("business.description", "企业描述不能为空");
			}
			if (business.getUrl() == null || "".equals(business.getUrl())) {
				addFieldError("business.url", "企业详情链接不能为空");
			}if (business.getEmail() == null || "".equals(business.getEmail())) {
				addFieldError("business.email", "企业邮箱不能为空");
			}
			
		}
	
	/**
	 * 注册，新增企业
	 * @return
	 */
	public String add() {
		int result = businessService.addBusiness(business);
		if (result == 0) {
			//数据库中已有该记录
			message = "数据库中已有该记录";
			return "regBusiness";
		} else if (result == 1){
			//插入成功 应该跳转到登录页面的，
			//TODO 目前登录页面暂未放进来，故先跳到企业中心
			message = "注册成功";
			return "businessCenter";
		} else if (result == 2) {
			errorMessage = "登录密码和确认密码不一致";
			return "regBusiness";
		}
		return SUCCESS;
	}

}
