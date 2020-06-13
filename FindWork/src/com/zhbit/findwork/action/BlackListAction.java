package com.zhbit.findwork.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.BlackList;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.service.BlackListService;

public class BlackListAction extends ActionSupport{
	
	private BlackListService blackListService;
	private BlackList blackList;
	private List<BlackList> blist;
	private Business business;
	private Advertise advertise;
	//分页参数
	private int currentPage;       //当前处于第几页
	private int lines;             //总条数
	private int totalPages;        //
	private List<String> plist;
	private static int page_line = 6;
	private int firstResult;
	
	/**
	 * 跳转处理投诉页面
	 * */
	public String toCheckComplain(){
		
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
		
		for (BlackList blackList : blist) {
			System.out.println(blackList.getComment());
		}
		
		return "toCheckComplain";
	}
	
	/**
	 * 跳转处理投诉详情
	 * */
	public String toShowComplain(){
		blackList = blackListService.getBlackListById(blackList.getId());
		
		if (blackList.getAdvertise() != null) {
			advertise = blackList.getAdvertise();
			return "toShowComplainForAdvertise";
		}else if(blackList.getBusiness() != null) {
			business = blackList.getBusiness();
			return "toShowComplainForBusiness";
		}
		
		return "toShowComplain";
	}
	
	public BlackListService getBlackListService() {
		return blackListService;
	}
	public void setBlackListService(BlackListService blackListService) {
		this.blackListService = blackListService;
	}
	public BlackList getBlackList() {
		return blackList;
	}
	public void setBlackList(BlackList blackList) {
		this.blackList = blackList;
	}

	public List<BlackList> getBlist() {
		return blist;
	}


	public void setBlist(List<BlackList> blist) {
		this.blist = blist;
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
	public static int getPage_line() {
		return page_line;
	}
	public static void setPage_line(int page_line) {
		BlackListAction.page_line = page_line;
	}
	public int getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Advertise getAdvertise() {
		return advertise;
	}

	public void setAdvertise(Advertise advertise) {
		this.advertise = advertise;
	}
	

}
