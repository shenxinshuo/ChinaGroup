package com.zhbit.findwork.service.impl;

import com.zhbit.findwork.dao.CvDao;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.service.CvService;

public class CvServiceImpl implements CvService {
	
	private CvDao cvDao;
	

	public CvDao getCvDao() {
		return cvDao;
	}

	public void setCvDao(CvDao cvDao) {
		this.cvDao = cvDao;
	}

	@Override
	public boolean addCv(Cv cv) {
		if (cvDao.isExistbyName(cv.getName())) {
			return false;
		}else {
			cvDao.addCv(cv);
			return true;
		}
	
	
	}

	@Override
	public boolean update(Cv cv) {
		//如果用户名存在数据库
		if (cvDao.isExistbyName(cv.getName())) {
			//判断此用户名是否为原本的用户名
			if (cv.getId()!=cvDao.getCvByName(cv.getName()).getId()) {
				//如果不是原本的用户名，则更新失败
				return false;
			}
			//如果用户名是原本的用户名，更新成功
			cvDao.updateCv(cv);
			return true;
		}else {
			cvDao.updateCv(cv);
			return true;
		}
	}

	@Override
	public Cv getCvByID(int id) {
		// TODO Auto-generated method stub
		return cvDao.getCvByID(id);
	}

	@Override
	public boolean deleteCvByID(int id) {
		// 判断此id是否有用户，若果没有则删除失败
		if (cvDao.getCvByID(id)!=null) {
			cvDao.deleteCvByID(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Cv getCvByName(String name) {
		// TODO Auto-generated method stub
		return cvDao.getCvByName(name);
	}

}
