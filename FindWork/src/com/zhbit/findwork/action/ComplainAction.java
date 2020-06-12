package com.zhbit.findwork.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.BlackListService;
import com.zhbit.findwork.service.BusinessService;

/**
 * 处理企业和招聘信息投诉的action
 * @author SX
 * @date 2020年6月11日
 */
public class ComplainAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userid;		//接收投诉者id
	private int businessid; //接收被投诉企业id
	private int advertiseid;//接收被投诉招聘信息id
	private String complainReason;//投诉详情信息
	private String message;	//信息回显
	
	private BusinessService businessService;	//注入企业的业务逻辑层对象
	private BlackListService blackListService; //注入黑名单业务逻辑对象
	private AdvertiseService advertiseService;	//注入招聘信息业务逻辑对象
	
	

	
	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}
	public int getAdvertiseid() {
		return advertiseid;
	}
	public void setAdvertiseid(int advertiseid) {
		this.advertiseid = advertiseid;
	}
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setBlackListService(BlackListService blackListService) {
		this.blackListService = blackListService;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public String getComplainReason() {
		return complainReason;
	}
	public void setComplainReason(String complainReason) {
		this.complainReason = complainReason;
	}

	/**
	 * 处理企业投诉
	 * @return
	 */
	public String dealBusinessComplain() {
		//System.out.println("进入举报流程");
		User user = new User();
		user.setId(userid);
		Business business = new Business();
		business.setId(businessid);
		
		boolean result = blackListService.addBusinessToBlackList(user, business, complainReason);
		//true:举报成功   false:已经举报过
		Business businessForShow = businessService.getBusinessByID(businessid);
		ActionContext.getContext().put("business", businessForShow);
		if (result) {
			message = "举报成功，等待管理员处理";
			return "showBusiness";
		} else {
			message = "请不要重复举报！";
			return "showBusiness";
		}
		
	}
	
	/**
	 * 处理招聘信息投诉
	 * @return
	 */
	public String dealAdvertiseComplain() {
		User user = new User();
		user.setId(userid);
		Advertise advertise = new Advertise();
		advertise.setId(advertiseid);
		
		boolean result = blackListService.addAdvertiseToBlackList(user, advertise, complainReason);
		//true:举报成功   false:已经举报过
		Advertise as = advertiseService.getAdvertiseByID(advertiseid);
		ActionContext.getContext().put("as", as);
		Integer s = (Integer) ActionContext.getContext().getSession().get("LOGINED_ROLE");
		Integer isUser = 9;
		if (s == 2) isUser = 1;
		if (s == 1) isUser = 0;
		ServletActionContext.getRequest().setAttribute("isUser", isUser);
		if (result) {
			message = "举报成功，等待管理员处理";
			return "showAdvertise";
		} else {
			message = "请不要重复举报！";
			return "showAdvertise";
		}
	}
}
