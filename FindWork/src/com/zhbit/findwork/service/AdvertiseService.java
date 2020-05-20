package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Advertise;


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
}
