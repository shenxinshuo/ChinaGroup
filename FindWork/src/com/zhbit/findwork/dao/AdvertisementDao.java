package com.zhbit.findwork.dao;

import java.util.List;

import com.zhbit.findwork.entity.Advertisement;

/**
 * 广告Dao接口
 * @author 王德略
 *
 */
public interface AdvertisementDao {
 /**
  * 添加一个广告
  **/
	public void add(Advertisement ad);
/**
*  通过id获取广告
 **/
	public Advertisement getAdvertisementById(int adId);
/**
*  修改广告
**/
	public void change(Advertisement ad);
	/**
	*  删除广告
	**/
	public void delete(int adId);
	/**
	*  获取所有的广告
	**/
	public List<Advertisement> getAllAdvertisements();
	
}
