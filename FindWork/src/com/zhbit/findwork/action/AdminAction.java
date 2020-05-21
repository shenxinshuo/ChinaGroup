package com.zhbit.findwork.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Administrator;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.service.AdministratorService;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.BusinessService;

public class AdminAction extends ActionSupport{

	private AdministratorService adminService;
	private BusinessService businessService;
	private AdvertiseService advertiseService;
	
	private Administrator admin;
	private Business business;
	private Advertise advertise;
	private List<Business> bs;
	private List<Advertise> as;
	private int currentPage;       //当前处于第几页
	private int lines;             //总条数
	private int totalPages;        //
	private List<String> plist;
	private static int page_line = 2;
	private int firstResult;
	
	public String showAdminCenter(){
		
		lines = businessService.getCountByCheckFlag(0);
		plist = new ArrayList<String>();
		
		for(int i=0,j=0;i<lines;i+=2,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		bs = businessService.getBusinessesByPageWithCheck(firstResult, page_line, 0);
		
		return "center";
		
	}
	
	public String showBusinessForCheck(){
		
		business = businessService.getBusinessByID(business.getId());
		return "showFC";
		
	}
	
	public String updateCheckFlag(){
		
		System.out.println(business.getId()+business.getComment());
		business.setCheck_flag(1);
		businessService.updateBusinessCheckFlag(business);;
		
		lines = businessService.getCountByCheckFlag(0);
		plist = new ArrayList<String>();
		for(int i=0;i<lines;i+=6){
			plist.add(String.valueOf(i+1));
		}
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		bs = businessService.getBusinessesByPageWithCheck(firstResult, page_line, 0);
		
		return "check";
		
	}
	
	public String checkNotPass(){
		
		business.setCheck_flag(-1);
		businessService.updateBusinessCheckFlag(business);
		
		lines = businessService.getCountByCheckFlag(0);
		plist = new ArrayList<String>();
		for(int i=0,j=0;i<lines;i+=2,j++){
			plist.add(String.valueOf(j+1));
		}
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		bs = businessService.getBusinessesByPageWithCheck(firstResult, page_line, 0);
		
		return "notpass";
		
	}
	
	public String checkAdver(){
		
		Advertise ad = advertiseService.getAdvertiseByID(advertise.getId());
		ad.setCheck(1);
		ad.setComment(advertise.getComment());
 		advertiseService.updateAdvertese(ad);
 		
 		lines = advertiseService.getUnFinAdvertiseCount();
		plist = new ArrayList<String>();
		for(int i=0,j=0;i<lines;i+=2,j++){
			plist.add(String.valueOf(j+1));
		}
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		as = advertiseService.getAdvertiseByPageWithCheck(firstResult, page_line, 0);
 		
		return "checkAdver";
		
	}
	
	public String checkAdverNotPass(){
		
		Advertise ad = advertiseService.getAdvertiseByID(advertise.getId());
		ad.setCheck(-1);
		ad.setComment(advertise.getComment());
 		advertiseService.updateAdvertese(ad);
 		
 		lines = advertiseService.getUnFinAdvertiseCount();
		plist = new ArrayList<String>();
		for(int i=0,j=0;i<lines;i+=2,j++){
			plist.add(String.valueOf(j+1));
		}
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		as = advertiseService.getAdvertiseByPageWithCheck(firstResult, page_line, 0);
		
		return "adnotpass";
		
	}
	
	public String showAdvertiseForCheck(){
		
		advertise = advertiseService.getAdvertiseByID(advertise.getId());
		return "showAd";
		
	}
	
	public String showAdverList(){
		
		lines = advertiseService.getUnFinAdvertiseCount();
		plist = new ArrayList<String>();
		for(int i=0,j=0;i<lines;i+=2,j++){
			plist.add(String.valueOf(j+1));
		}
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		as = advertiseService.getAdvertiseByPageWithCheck(firstResult, page_line, 0);
		
		return "showAdList";
		
	}
	
	public void validateLogin(){
		
		//判断用户名是否为空
		if(admin.getAccount()==null||admin.getAccount().equals("")){
			this.addFieldError("adminName", "用户名不能为空");
			System.out.println("0");
		}else if(admin.getPassword()==null || admin.getPassword().equals("")){
			this.addFieldError("adminPassword", "密码不能为空");
		}else if(adminService.getAdminByNameAndPassword(admin.getAccount(), admin.getPassword()) == null){
			this.addFieldError("adminName", "用户名或密码错误");
			this.addFieldError("adminPassword", "用户名或密码错误");
		}
	}
	
	public String login(){
		
		lines = businessService.getCountByCheckFlag(0);
		plist = new ArrayList<String>();
		for(int i=0,j=0;i<lines;i+=2,j++){
			plist.add(String.valueOf(j+1));
		}
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		bs = businessService.getBusinessesByPageWithCheck(firstResult, page_line, 0);
		
		Administrator a = adminService.getAdminByNameAndPassword(admin.getAccount(), admin.getPassword());
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_ADMIN", a);
		
		
		return "login";
		
	}
	
	public String logout(){
		
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_ADMIN",null);
		
		return "logout";
		
	}
	
	public AdministratorService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdministratorService adminService) {
		this.adminService = adminService;
	}

	public BusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public List<Business> getBs() {
		return bs;
	}

	public void setBs(List<Business> bs) {
		this.bs = bs;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<String> getPlist() {
		return plist;
	}

	public void setPlist(List<String> plist) {
		this.plist = plist;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public AdvertiseService getAdvertiseService() {
		return advertiseService;
	}

	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}

	public Advertise getAdvertise() {
		return advertise;
	}

	public void setAdvertise(Advertise advertise) {
		this.advertise = advertise;
	}

	public List<Advertise> getAs() {
		return as;
	}

	public void setAs(List<Advertise> as) {
		this.as = as;
	}
	
}
