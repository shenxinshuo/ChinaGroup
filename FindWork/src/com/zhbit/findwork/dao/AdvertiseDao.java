package com.zhbit.findwork.dao;
/**
 * @author 钦治
 */

import java.util.List;

import com.zhbit.findwork.entity.Advertise;

public interface AdvertiseDao {

	/*
	 * 新增职位
	 * @param advertise
	 */
	public void addAdvertise(Advertise advertise);
	/*
	 * 修改职位信息
	 * @param advertise
	 */
	public void updateAdvertise(Advertise advertise);
	/*
	 * 根据ID删除职位信息
	 * @param advertise
	 */
	public void deleteAdvertiseByID(int id);
	/*
	 *根据ID查询职位信息
	 *
	 * @param advertise
	 */
	public Advertise getAdvertiseByID(int id);
	
	
	/*
	 *条件查询职位信息
	 *
	 * @param advertise
	 */
	public List<Advertise> getAdvertiseByExample(Advertise advertise);
	
	
	/**
	 * 获取所有企业职位未审核信息
	 * @param advertise
	 */
	public List<Advertise> getUnFinAdvertise();
	
	/**
	 * 根据审核标志获取招聘信息列表
	 * @param firstResult
	 * @param maxResults
	 * @param check
	 * @return
	 */
	public List<Advertise> getAdvertiseByPageWithCheck(int firstResult,
			int maxResults, int check);
	
	/**
	 * 根据企业id获取招聘信息
	 * @param bid
	 * @param check
	 * @return
	 */
	public List<Advertise> getAdvertiseByBid(int bid,int check);
	
	/**
	 * 根据企业id获取该企业名下招聘信息条数
	 * @param bid
	 * @return
	 */
	public int getAdvertiseCountByBid1(int bid);
	//根据企业id和审核标识获取该企业名下招聘信息条数
	public int getAdvertiseCountByBid(int bid, int check);
	
	//根据未发布的招聘信息条数
	public int getUnFinAdvertiseCount();
	
	//根据企业id获取招聘信息分页列表
	public List<Advertise> getAdvertiseByBid(int bid,int firstResult,int maxResults);
	
	
	//根据岗位搜索招聘信息列表（分页）
	public List<Advertise> getAdvertisesByPostSearch(String postName, int firstResult, int maxResults);
	
	//根据岗位搜索招聘信息列数据条数
	public int getCountByPostSearch(String postName);
	
	//根据城市搜索
	
	//根据工资搜索
}
