package com.zhbit.findwork.dao;
/**
 * @author 段世平
 */
import java.util.List;

import com.zhbit.findwork.entity.Cv;

public interface CvDao {

	/**
	 * 根据用户名字查询用户是否存在
	 * @return
	 */
	public boolean isExistbyName(String name);
	/**
	 * 根据用户id查询用户是否存在
	 * @return
	 */
	public boolean isExistbyId(String id);
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
}
