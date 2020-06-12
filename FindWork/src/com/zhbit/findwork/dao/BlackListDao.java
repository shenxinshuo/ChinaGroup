package com.zhbit.findwork.dao;

import java.util.List;

import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.BlackList;
import com.zhbit.findwork.entity.Business;


/**
 * 黑名单功能
 * @author 王德略
 *
 */
public interface BlackListDao {
	/**
	 * 添加一个黑名单对象
	 * */
	public void add(BlackList blacklist);
	/**
	 * 判断该用户举报的企业对象是否已经存在
	 * */	
	public boolean isBusinessExited(int userId,int businessId);
	/**
	 * 判断该用户举报的招聘信息对象是否已经存在
	 * */	
	public boolean isAdvertiseExited(int userId,int advertiseId);
	/**
	 * 获取黑名单中的所有未审核的企业对象
	 * */	
	public List<Business> getAllBusinesses();
	/**
	 * 获取黑名单中的所有未审核的招聘信息对象
	 * */	
	public List<Advertise> getAllAdvertises();
	/**
	 * 审核投诉企业成功
	 * */
	public void complainsBusinessOfSuccess(int businessId);
	/**
	 * 审核投诉企业失败
	 * */
	public void complainsBusinessOfFaile(int businessId);
	/**
	 * 审核投诉招聘信息成功
	 * */
	public void complainsAdvertiseOfSuccess(int AdvertiseId);
	/**
	 * 审核投诉招聘信息失败
	 * */
	public void complainsAdvertiseOfFaile(int AdvertiseId);
}
