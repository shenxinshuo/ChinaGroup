package com.zhbit.findwork.dao;
/**
 * @author 段世平
 */
import java.util.List;

import com.zhbit.findwork.entity.Cv;

public interface CvDao {

	/*
	 * 新增简历
	 * @param cv
	 */
	public void addCv(Cv cv );
	/*
	 * 修改简历信息
	 * @param cv
	 */
	public void updateCv(Cv cv);
	/*
	 * 根据ID删除简历信息
	 * @param cv
	 */
	public void deleteCvByID(int id);
	/*
	 *根据ID查询简历信息
	 *
	 * @param id
	 */
	public Cv getCvByID(int id);
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
	public List<Cv> getAllCvList();
}
