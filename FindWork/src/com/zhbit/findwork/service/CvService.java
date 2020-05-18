package com.zhbit.findwork.service;

import com.zhbit.findwork.entity.Cv;

/**
 * 简历业务接口
 * @author tongr
 *@description
 *@date 2020年5月16日
 */
public interface CvService {
	/**
	 * 新增简历信息
	 * @param cv
	 */
	public boolean addCv(Cv cv);
	/**
	 * 修改简历信息
	 * @param cv
	 */
	public boolean update(Cv cv);
	/**
	 * 根据ID查询简历信息
	 * @param cv
	 */
	public Cv getCvByID(int id);
	/**
	 * 根据ID删除简历信息
	 * @param cv
	 */
	public boolean deleteCvByID(int id);
	/**
	 * 根据用户名字查询简历信息
	 * @param name
	 * @return 
	 */
	public Cv getCvByName(String name);
	

}
