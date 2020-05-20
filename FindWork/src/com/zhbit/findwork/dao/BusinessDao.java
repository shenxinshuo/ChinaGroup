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
	 * 根据名字和密码查询企业（登录）
	 * @param name
	 * @param password
	 * @return
	 */
	public List<Business> getBusinessByNameAndPassword(String name, String password);
	
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
	 * 根据企业名字查询企业信息（全表查询，无论是否被删除）
	 * 因为修改时遇到问题：企业可以修改自己的企业名为被删除的企业名（这不合理），
	 * 应该等我们把数据库的数据删掉后这个名字才可用，故增加此方法
	 * @param name
	 * @return
	 */
	public List<Business> getBusinessesByNameInAll(String name);
	
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
	 * 获取某一页的企业信息（根据审核状态）
	 * 0:待审核 1：通过 -1：未通过  
	 * @param firstResult
	 * @param maxResults
	 * @param check_flag 审核状态
	 * @return
	 */
	public List<Business> getBusinessesByPageWithCheck(int firstResult, int maxResults, int check_flag);
	
	
	/**
	 * 获取数据条数（根据审核状态）
	 * @param flag
	 * @return
	 */
	public int getCountByCheckFlag(int flag);
	
	/**
	 * 获取表中数据条数
	 * @return
	 */
	public int getCount();
	
	/**
	 * 根据企业名字搜索企业（模糊查询）
	 * @param firstResult
	 * @param maxResults
	 * @param name要查询的企业名
	 * @return
	 */
	public List<Business> getBusinessesByNameSearch(int firstResult, int maxResults, String name);
	
	/**
	 * 获取模糊查询的数据条数
	 * @param name
	 * @return
	 */
	public int getCountByNameSearch(String name);
	
}



















