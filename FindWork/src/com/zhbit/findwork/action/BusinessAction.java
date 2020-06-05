package com.zhbit.findwork.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.BusinessService;

public class BusinessAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Business business;
	private List<Business> businesses;
	private BusinessService businessService;
	private AdvertiseService advertiseService;
	private String message;				//用于返回信息给页面，提示用户
	private String errorMessage;		//显示异常信息
	private File license;				//营业执照文件
	private String licenseFileName;		//文件名称
	private String licenseContentType;	//文件类型
	private String searchName;			//用户根据企业名字模糊查询时输入的值
	private int currentPage;			//当前页面（分页）
	private int firstResult;			//首条记录（分页）
	private int lastPage;				//最后一页页码
	private int pageSize = Integer.parseInt(ServletActionContext.getServletContext().getInitParameter("maxResults"));
	private List<Advertise> advertises;	//企业名下的所有招聘信息
	private String businessProvince;	//接收企业所在省份的值
	//private int maxResults = 5;
	
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	public String getBusinessProvince() {
		return businessProvince;
	}
	public void setBusinessProvince(String businessProvince) {
		this.businessProvince = businessProvince;
	}
	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}
	
	public List<Advertise> getAdvertises() {
		return advertises;
	}


	public void setAdvertises(List<Advertise> advertises) {
		this.advertises = advertises;
	}


	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentPage() {
		return currentPage;
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
	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}
	public List<Business> getBusinesses() {
		return businesses;
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
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getSearchName() {
		return searchName;
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
			} else {
				if (!business.getTelephone().matches("(13|14|15|18|17)[0-9]{9}")) {
					this.addFieldError("business.telephone", "请输入正确的手机号码");
				}
			}
			if (business.getPassword() == null || "".equals(business.getPassword())) {
				addFieldError("business.password", "登录密码不能为空");
			} else {
				if (business.getPassword().length() < 6 || business.getPassword().length() > 16) {
					addFieldError("business.password", "密码长度必须在6到18位之间");
				}
			}
			if (business.getConfirmPassword() == null || "".equals(business.getConfirmPassword())) {
				addFieldError("business.confirmPassword", "确认密码不能为空");
			}
			if (business.getAddress() == null || "".equals(business.getAddress())) {
				addFieldError("business.address", "企业地址不能为空");
			} else {
				if (business.getAddress().length()>255) {
					this.addFieldError("business.address", "企业地址长度不能超过255");
				}
			}
			if (business.getDescription() == null || "".equals(business.getDescription())) {
				addFieldError("business.description", "企业描述不能为空");
			} else {
				if (business.getDescription().length() > 255) {
					this.addFieldError("business.description", "企业描述长度不能超过255");
				}
			}
			if (business.getUrl() == null || "".equals(business.getUrl())) {
				addFieldError("business.url", "企业详情链接不能为空");
			}if (business.getEmail() == null || "".equals(business.getEmail())) {
				addFieldError("business.email", "企业邮箱不能为空");
			} else {
				if (!business.getEmail().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
					this.addFieldError("business.email", "请输入正确的邮箱地址");
				}
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
			return "businessLogin";
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
		//List<Advertise> temp = business.getAdvertises();
		int count = advertiseService.getAdvertiseCountByBid(business.getId(), 0) + advertiseService.getAdvertiseCountByBid(business.getId(), 1);
		this.getPagingParameter(count);
		if (currentPage < 1) currentPage = 1;
		if (currentPage > this.lastPage){
			currentPage = lastPage;
			this.firstResult = (this.currentPage-1)*this.pageSize;
		}
		//advertises = temp.subList((currentPage-1)*pageSize + 1, pageSize > temp.size() ? temp.size() : pageSize);
		advertises = advertiseService.getAdvertiseByBid(business.getId(), firstResult, pageSize);
		ActionContext.getContext().put("count", count);
		
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
				} else {
					if (!business.getTelephone().matches("(13|14|15|18|17)[0-9]{9}")) {
						this.addFieldError("business.telephone", "请输入正确的手机号码");
					}
				}
				if (business.getAddress() == null || "".equals(business.getAddress())) {
					addFieldError("business.address", "企业地址不能为空");
				} else {
					if (business.getAddress().length()>255) {
						this.addFieldError("business.address", "企业地址长度不能超过255");
					}
				}
				if (business.getDescription() == null || "".equals(business.getDescription())) {
					addFieldError("business.description", "企业描述不能为空");
				} else {
					if (business.getDescription().length() > 255) {
						this.addFieldError("business.description", "企业描述长度不能超过255");
					}
				}
				if (business.getUrl() == null || "".equals(business.getUrl())) {
					addFieldError("business.url", "企业详情链接不能为空");
				}if (business.getEmail() == null || "".equals(business.getEmail())) {
					addFieldError("business.email", "企业邮箱不能为空");
				} else {
					if (!business.getEmail().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
						this.addFieldError("business.email", "请输入正确的邮箱地址");
					}
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
			Business business = businessService.getBusinessByID(this.business.getId());
			//advertises = business.getAdvertises().subList(1, pageSize > business.getAdvertises().size() ? business.getAdvertises().size() : pageSize);
			advertises = advertiseService.getAdvertiseByBid(business.getId(), firstResult, pageSize);
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
	
	/**
	 * 根据企业名字搜索企业
	 * @return
	 */
	public String searchByName() {
		int count = businessService.getCountByNameSearch(searchName);
		this.getPagingParameter(count);
		ActionContext.getContext().put("count", count);
		ActionContext.getContext().put("searchName", searchName);
		businesses = businessService.getBusinessesByNameSearch(firstResult, pageSize, searchName);
		return "showSearchResultByName";
	}
	//根据当前页码和页面大小计算出分页需要的数据
	private void getPagingParameter(int count) {
		this.firstResult = (this.currentPage-1)*this.pageSize;
		this.lastPage = (int) Math.ceil(count/(this.pageSize*1.0));
		return ;
	}
	
	public String showBusinessInfo() {
		business = businessService.getBusinessByID(business.getId());
		return "showBusinessInfo";
	}
	
}
