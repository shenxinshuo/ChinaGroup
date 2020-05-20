package com.zhbit.findwork.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.dao.AdvertiseDao;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.BusinessService;

public class AdvertiseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private Advertise advertise;
	private AdvertiseService advertiseService;
	private String message;				//用于返回信息给页面，提示用户
	private String errorMessage;		//显示异常信息
	
	
	public void addAdvertise(){
		/*HttpServletResponse response=ServletActionContext.getResponse(); 
		response.setContentType("text/html;charset=utf-8"); */
		// PrintWriter out = null;
		try {
			advertiseService.addAdvertese(advertise);
			//out = response.getWriter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		/* out.println("success"); 
		 out.flush(); 
		 out.close(); */
	}
	
	
	
	public String toUnFinAdvertise(){
		Advertise advertise = new Advertise();
		advertise.setCheck(0);
		advertise.setDeleteFlag(0);
		List<Advertise>  l = advertiseService.getAdvertiseByExample(advertise);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("list", l);
		return "toUnFinAdvertise";
	}
	
	public void deleteAdvertise(){
		try {
			advertiseService.deleteAdvertiseByID(advertise.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String toUpdateAdvertise(){
		int check = advertise.getCheck();
		advertise = advertiseService.getAdvertiseByID(advertise.getId());
		advertise.setCheck(check);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("advertise", advertise);
		List<Map<String,String>> l = new ArrayList<Map<String,String>>();
		Map<String, String> m = new HashMap<String, String>();
		m.put("name", "全职");
		m.put("value", "0");
		l.add(m);
		m = new HashMap<String, String>();
		m.put("name", "实习");
		m.put("value", "1");
		l.add(m);
		m = new HashMap<String, String>();
		m.put("name", "兼职");
		m.put("value", "2");
		l.add(m);
		req.setAttribute("advertiseType", l);
		req.setAttribute("isEdit", 1);
		return "toUpdateAdvertise";
	}
	
	
	public void updateAdvertise(){
		try {
			advertiseService.updateAdvertese(advertise);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String toFinAdvertise(){
		Advertise advertise = new Advertise();
		advertise.setCheck(1);
		advertise.setDeleteFlag(0);
		List<Advertise>  l = advertiseService.getAdvertiseByExample(advertise);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("list", l);
		return "toFinAdvertise";
	}
	
	public String detailAdvertise(){
		Advertise  as =  advertiseService.getAdvertiseByID(advertise.getId());
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("as", as);
		return "detailAdvertise";
	}
	
	
	public String toAdd(){
		return "toAdd";
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
	public Advertise getAdvertise() {
		return advertise;
	}
	public void setAdvertise(Advertise advertise) {
		this.advertise = advertise;
	}
	public AdvertiseService getAdvertiseService() {
		return advertiseService;
	}
	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}

}
