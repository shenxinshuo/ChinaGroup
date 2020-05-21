package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Cv;

/**
 * 简历业务接口
 * @author 段世平
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
	public boolean updateCv(Cv cv);
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
	/**
	 * 获取简历所有信息
	 * @return
	 */
	public List<Cv> getAllCv();
	

}
