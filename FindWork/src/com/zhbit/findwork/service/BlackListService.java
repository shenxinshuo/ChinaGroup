package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.BlackList;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.User;
/**
 * 黑名单功能业务接口
 * @author 王德略
 * @description TODO
 * @date 2020年6月12日
 */
public interface BlackListService {
	/**
	 * 用户把企业加入黑名单表
	 * 未举报过，加入成功，返回值 true 否之 false
	 * 
	 * conmment参数是举报填写的理由
	 * */	
	public boolean addBusinessToBlackList(User user,Business business,String comment);		
	/**
	 * 用户把招聘信息加入黑名单表
	 * 未举报过，加入成功，返回值 true 否之 false
	 * conmment参数是举报填写的理由
	 * 
	 * */	
	public boolean addAdvertiseToBlackList(User user,Advertise advertise,String comment);
	/**
	 * 获取所有被举报的,管理者还没审核的企业
	 * 
	 * */	
	public List<Business> getAllBusinesses();
	/**
	 * 获取所有被举报的,管理者还没审核的招聘信息
	 * 
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
	public void complainsAdvertiseOfSuccess(int advertiseId);
	/**
	 * 审核投诉招聘信息失败
	 * */
	public void complainsAdvertiseOfFaile(int advertiseId);
	/**
	 * 查询未处理的投诉总数
	 * */
	public int getCountByStatus(int status);
	/**
	 * 分页查询未处理的投诉
	 * */
	public List<BlackList> getBlackListsByPageWithStatus(int firstResult, int maxResults, int status);
	/**
	 * 根据id查询
	 * */
	public BlackList getBlackListById(int id);
	/**
	 * 更新黑名单
	 * */
	public void updateBlackListStatus(BlackList blackList);
}
