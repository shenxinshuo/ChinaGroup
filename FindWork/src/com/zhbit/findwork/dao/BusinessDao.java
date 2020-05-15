package com.zhbit.findwork.dao;

import java.util.List;

import com.zhbit.findwork.entity.Business;

/**
 * 
 * @author SX
 *
 */
public interface BusinessDao {
	
	/**
	 * 根据企业名字查询企业是否存在
	 * @return
	 */
	public boolean isExist(String name);
	
	/**
	 * 新增企业
	 * @param business
	 */
	public void addBusiness(Business business);
	
	/**
	 * 修改企业信息
	 * @param business
	 */
	public void updateBusiness(Business business);
	
	/**
	 * 根据ID查询企业信息
	 * @param id
	 * @return
	 */
	public Business getBusinessByID(int id);
	
	/**
	 * 根据企业名字查询企业信息（查询用）
	 * @param name
	 * @return
	 */
	public List<Business> getBusinessesByName(String name);
	
	/**
	 * 根据ID删除企业
	 * @param id
	 */
	public void deleteBusinessByID(int id);
	
	/**
	 * 根据分页返回某一页的企业信息列表
	 * @param firstResult 要查询的第一条记录
	 * @param maxResults  页面大小
	 * @return
	 */
	public List<Business> getBusinessesByPage(int firstResult, int maxResults);
	
	/**
	 * 获取表中数据条数
	 * @return
	 */
	public int getCount();
	
}



















