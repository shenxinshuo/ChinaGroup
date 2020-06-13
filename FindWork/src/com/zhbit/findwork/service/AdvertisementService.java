package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Advertisement;

/**
 * 广告业务接口
 * @author 王德略
 * @description TODO
 * @date 2020年6月13日
 */
public interface AdvertisementService {
/**
 * 添加一个广告
 * */
	public boolean addAD(Advertisement ad);
	/**
	 * 删除一个广告
	 * */
	public boolean deleteAD(int adId);
	/**
	 * 修改广告
	 * */
	public boolean changeAD(Advertisement ad);
	/**
	 * 通过广告id获取该广告
	 * */
	public Advertisement getAdvertisementById(int adId);
	/**
	*  获取所有的广告
	**/
	public List<Advertisement> getAllAdvertisements();
}
