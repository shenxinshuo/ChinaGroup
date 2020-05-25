package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Cv;


/**
 * 职位业务接口
 *@author 钦治
 *@description
 *@date 2020年5月19日
 */
public interface AdvertiseService {
	/**
	 * 新增职位信息
	 * @param advertise
	 */
	public boolean addAdvertese(Advertise advertise);
	/**
	 * 修改职位信息
	 * @param advertise
	 */
	public boolean updateAdvertese(Advertise advertise);
	/**
	 * 根据ID查询职位信息
	 * @param advertise
	 */
	public Advertise getAdvertiseByID(int id);
	
	/**
	 * 根据ID删除职位信息
	 * @param advertise
	 */
	public boolean deleteAdvertiseByID(int id);
	
	
	/**
	 * 条件查询职位信息
	 * @param advertise
	 */
	public List<Advertise> getAdvertiseByExample(Advertise advertise);
	
	
	/**
	 * 获取所有企业职位未审核信息
	 * @param advertise
	 */
	public List<Advertise> getUnFinAdvertise();
	
	/**
	 * 获取所有企业职位未审核信息总数
	 * @param advertise
	 */
	public int getUnFinAdvertiseCount();
	
	/**
	 * 分页查询未审核的职位信息（根据审核状态）
	 * 0:未审核 1：已审核
	 * @param firstResult
	 * @param maxResults
	 * @param check 审核状态
	 * @return
	 */
	public List<Advertise> getAdvertiseByPageWithCheck(int firstResult, int maxResults, int check);
	
	/**
	 * 根据企业id和审核状态获取职位信息
	 * 0:未审核 1：已审核
	 * @param advertise
	 */
	public List<Advertise> getAdvertiseByBid(int bid,int check);
	
	
	/**
	 * 根据企业id和审核状态获取职位信息数量
	 * 0:未审核 1：已审核
	 * @param advertise
	 */
	public int getAdvertiseCountByBid(int bid,int check);
	
	
	/**
	 * 根据企业id获取职位信息数量
	 * 
	 * @param advertise
	 */
	public int getAdvertiseCountByBid(int bid);
	
	/**
	 * 根据企业id获取职位信息
	 * 
	 * @param advertise
	 */
	public List<Advertise> getAdvertiseByBid(int bid,int firstResult, int maxResults);
	
	
	//根据岗位搜索招聘信息列表（分页）
	public List<Advertise> getAdvertisesByPostSearch(String postName, int firstResult, int maxResults);
	
	//根据岗位搜索招聘信息数据条数
	public int getCountByPostSearch(String postName);
	
	//企业查看已收简历
	public List<Cv> getCVOfAdvertise(int aID, int firstResult, int maxResults);
	
	//企业查看已收简历的总数
	public int getCVCountOfAdvertise(int aID);
}
