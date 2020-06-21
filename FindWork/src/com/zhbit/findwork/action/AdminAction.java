package com.zhbit.findwork.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Administrator;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Advertisement;
import com.zhbit.findwork.entity.BlackList;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.service.AdministratorService;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.AdvertisementService;
import com.zhbit.findwork.service.BlackListService;
import com.zhbit.findwork.service.BusinessService;

public class AdminAction extends ActionSupport{

	private AdministratorService adminService;
	private BusinessService businessService;
	private AdvertiseService advertiseService;
	private BlackListService blackListService;
	
	private BlackList blackList;
	private List<BlackList> blist;
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
	
	private AdvertisementService  advertisementService;
	private String url[]= new String [6];
	
	public AdvertisementService getAdvertisementService() {
		return advertisementService;
	}

	public void setAdvertisementService(AdvertisementService advertisementService) {
		this.advertisementService = advertisementService;
	}

	public String[] getUrl() {
		return url;
	}

	public void setUrl(String[] url) {
		this.url = url;
	}

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
	
	public String checkBComplain(){
		blackList = blackListService.getBlackListById(blackList.getId());
		advertise = advertiseService.getAdvertiseByID(advertise.getId());
		blackList.setDelete_flag(1);
		blackList.setStatus(1);
		advertise.setDeleteFlag(1);
		blackListService.updateBlackListStatus(blackList);
		advertiseService.updateAdvertese(advertise);
		
		lines = blackListService.getCountByStatus(0);
		plist = new ArrayList<String>();
		
		for(int i=0,j=0;i<lines;i+=6,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		blist = blackListService.getBlackListsByPageWithStatus(firstResult, page_line, 0);
		
		return "checkBComplain";
	}
	
	public String checkBComplainNotPass(){
		blackList = blackListService.getBlackListById(blackList.getId());
		blackList.setStatus(-1);
		blackListService.updateBlackListStatus(blackList);
		
		lines = blackListService.getCountByStatus(0);
		plist = new ArrayList<String>();
		
		for(int i=0,j=0;i<lines;i+=6,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		blist = blackListService.getBlackListsByPageWithStatus(firstResult, page_line, 0);
		
		return "checkBComplainNotPass";
	}
	
	public String checkBComplainForBusiness(){
		blackList = blackListService.getBlackListById(blackList.getId());
		blackList.setDelete_flag(1);
		blackList.setStatus(1);
		blackListService.updateBlackListStatus(blackList);
		businessService.deleteBusinessByID(business.getId());
		
		lines = blackListService.getCountByStatus(0);
		plist = new ArrayList<String>();
		
		for(int i=0,j=0;i<lines;i+=6,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		blist = blackListService.getBlackListsByPageWithStatus(firstResult, page_line, 0);
		
		return "checkBComplain";
	}
	
	public String checkBComplainForBusinessNotPass(){
		blackList = blackListService.getBlackListById(blackList.getId());
		blackList.setStatus(-1);
		blackListService.updateBlackListStatus(blackList);
		
		lines = blackListService.getCountByStatus(0);
		plist = new ArrayList<String>();
		
		for(int i=0,j=0;i<lines;i+=6,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		blist = blackListService.getBlackListsByPageWithStatus(firstResult, page_line, 0);
		
		return "checkBComplainNotPass";
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
		ac.getSession().put("LOGINED_USER", a);
		ac.getSession().put("LOGINED_ROLE", 5);
		
		List<Advertisement> ads=advertisementService.getAllAdvertisements();
		for(int i=0;i<ads.size();i++){
			url[ads.get(i).getPosition()]=ads.get(i).getUrl();
		}
		
		return "login";
		
	}
	
	public String logout(){
		
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("LOGINED_USER",null);
		ac.getSession().put("LOGINED_ROLE", null);
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

	public BlackList getBlackList() {
		return blackList;
	}

	public void setBlackList(BlackList blackList) {
		this.blackList = blackList;
	}

	public BlackListService getBlackListService() {
		return blackListService;
	}

	public void setBlackListService(BlackListService blackListService) {
		this.blackListService = blackListService;
	}

	public List<BlackList> getBlist() {
		return blist;
	}

	public void setBlist(List<BlackList> blist) {
		this.blist = blist;
	}
	
}
