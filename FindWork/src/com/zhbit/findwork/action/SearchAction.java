package com.zhbit.findwork.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.service.AdvertiseService;
/**
 * 搜索的action（包含企业和招聘信息）
 * 
 * @author SX
 * @description TODO
 * @date 2020年5月25日
 */
public class SearchAction extends ActionSupport{
	
	private String postName;
	private AdvertiseService advertiseService;
	private int currentPage = 1;			//当前页面（分页）默认当前页是首页
	private int firstResult;			//首条记录（分页）
	private int lastPage;				//最后一页页码
	private int pageSize = Integer.parseInt(ServletActionContext.getServletContext().getInitParameter("maxResults"));
	private List<Advertise> advertises;	//返回搜索的招聘信息列表
	private int count;					//结果数据条数
	
	
	
	public List<Advertise> getAdvertises() {
		return advertises;
	}
	public void setAdvertises(List<Advertise> advertises) {
		this.advertises = advertises;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	/**
	 * 根据岗位模糊搜索招聘信息
	 * @return
	 */
	public String getAdvertisesByPostSearch() {
		count = advertiseService.getCountByPostSearch(postName);
		this.getPagingParameter(count);
		advertises = advertiseService.getAdvertisesByPostSearch(postName, firstResult, pageSize);
		return "showAdvertisesByPostSearch";
	}
	//根据当前页码和页面大小计算出分页需要的数据
	private void getPagingParameter(int count) {
		this.firstResult = (this.currentPage-1)*this.pageSize;
		this.lastPage = (int) Math.ceil(count/(this.pageSize*1.0));
		return ;
	}
}
