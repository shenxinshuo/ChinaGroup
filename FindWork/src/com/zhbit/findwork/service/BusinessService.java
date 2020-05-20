package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Business;

/**
 * 企业业务接口
 * @author SX
 * @description TODO
 * @date 2020年5月16日
 */
public interface BusinessService {
	
	
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	public Business login(String name, String password);
	
	/**
	 * 新增企业
	 * @param business
	 */
	public int addBusiness(Business business);
	
	/**
	 * 修改企业信息
	 * @param business
	 */
	public int updateBusiness(Business business);
	
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
	 * 获取某一页的企业信息（根据审核状态）
	 * 0:待审核 1：通过 -1：未通过  
	 * @param firstResult
	 * @param maxResults
	 * @param check_flag 审核状态
	 * @return
	 */
	public List<Business> getBusinessesByPageWithCheck(int firstResult, int maxResults, int check_flag);
	
	/**
	 * 修改企业的审核状态
	 * @param business 传入审核过的企业对象(注册check_flag的值，0:待审核 1：通过 -1：未通过  )
	 * @return
	 */
	public void updateBusinessCheckFlag(Business business);
	
	/**
	 * 根据审核状态获取数据条数
	 * @param flag 审核状态标识（0:待审核 1：通过 -1：未通过）
	 * @return
	 */
	public int getCountByCheckFlag(int flag);
	
	/**
	 * 获取表中数据条数
	 * @return
	 */
	public int getCount();
}
