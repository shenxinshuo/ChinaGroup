package com.zhbit.findwork.dao;
/**
 * @author 钦治
 */

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
}
