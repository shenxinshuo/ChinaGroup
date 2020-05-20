package com.zhbit.findwork.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

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
	private File license;				//营业执照文件
	private String licenseFileName;		//文件名称
	private String licenseContentType;	//文件类型
	
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	public String getLicenseFileName() {
		return licenseFileName;
	}

	public void setLicenseFileName(String licenseFileName) {
		this.licenseFileName = licenseFileName;
	}

	public File getLicense() {
		return license;
	}
	public void setLicense(File license) {
		this.license = license;
	}
	public String getLicenseContentType() {
		return licenseContentType;
	}

	public void setLicenseContentType(String licenseContentType) {
		this.licenseContentType = licenseContentType;
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
	public void validateRegister() {
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
			} else {
				if (business.getPassword().length() < 8 || business.getPassword().length() > 16) {
					addFieldError("business.password", "密码长度必须在6到18位之间");
				}
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
			if (license == null) {
				addFieldError("license", "必须上传营业执照（审核用）");
			}
			
		}
	
	/**
	 * 注册，新增企业
	 * @return
	 */
	public String register() {
//		System.out.println(licenseFileName);
//		System.out.println(licenseContentType);
//		System.out.println(ServletActionContext.getServletContext().getRealPath("/upload/"+1+".jpg"));
//		System.out.println(temp[0]);
//		System.out.println(temp[temp.length-1]);
		String[] temp = licenseFileName.split("\\.");
		business.setLicense_path("/upload/businessLicense/"+business.getName()+"."+temp[temp.length-1]);
		int result = businessService.addBusiness(business);
		if (result == 0) {
			//数据库中已有该记录
			errorMessage = "数据库中已有该记录";
			return "regBusiness";
		} else if (result == 1){
			//插入成功 应该跳转到登录页面的，
			//TODO 目前登录页面暂未放进来，故先跳到企业中心
			File destFile = new File(ServletActionContext.getServletContext().getRealPath(business.getLicense_path()));
			try {
				FileUtils.copyFile(license, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			message = "注册成功";
			return "businessCenter";
		} else if (result == 2) {
			errorMessage = "登录密码和确认密码不一致";
			return "regBusiness";
		}
		return SUCCESS;
	}

	/**
	 * 显示企业中心
	 * @return
	 */
	public String showBusinessCenter() {
		business = businessService.getBusinessByID(business.getId());
		return "businessCenter";
	}
	
	/**
	 * 显示修改页面
	 * @return
	 */
	public String showUpdatePage() {
		business = businessService.getBusinessByID(business.getId());
		return "showUpdatePage";
	}
	
	//修改企业信息表单验证
		public void validateUpdate() {
				if (business.getName() == null || "".equals(business.getName())) {
					addFieldError("business.name", "企业名称不能为空");
				}
				if (business.getCity() == null || "".equals(business.getCity())) {
					addFieldError("business.city", "所在城市不能为空");
				}
				if (business.getTelephone() == null || "".equals(business.getTelephone())) {
					addFieldError("business.telephone", "联系电话不能为空");
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
	 * 修改企业信息
	 * @return
	 */
	public String update() {
		int result = businessService.updateBusiness(business);
		if (result == 0) {
			//修改成功
			message = "修改成功";
			return "businessCenter";
		} else if (result == 1) {
			//名字被占用
			errorMessage = "修改失败,该名字被抢先一步注册";
			Business businessTemp = businessService.getBusinessByID(business.getId());
			business.setRole(businessTemp.getRole());
			business.setCreate_at(businessTemp.getCreate_at());
			business.setLicense_path(businessTemp.getLicense_path());
			business.setCheck_flag(businessTemp.getCheck_flag());
			return "showUpdatePage";
		}
		return NONE;
	}
	
	
	
}
