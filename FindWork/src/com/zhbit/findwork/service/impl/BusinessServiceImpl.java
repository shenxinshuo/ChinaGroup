package com.zhbit.findwork.service.impl;

import java.util.List;

import com.zhbit.findwork.dao.BusinessDao;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.service.BusinessService;


/**
 * 企业业务接口实现类
 * @author SX
 * @description TODO
 * @date 2020年5月16日
 */
public class BusinessServiceImpl implements BusinessService {
	
	private BusinessDao businessDao;
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	/**
	 * 0:数据库中已有该记录
	 * 1:插入成功
	 */
	@Override
	public int addBusiness(Business business) {
		//新增之前先判断数据库中是否已有该记录
		boolean exist = businessDao.isExist(business.getName());
		if (exist == true) {
			//如果数据库中已有该记录则不插入数据
			return 0;
		} else {
			//如果数据库中不存在则插入数据
			businessDao.addBusiness(business);
			return 1;
		}
	}

	/**
	 * 0:数据修改成功
	 * 1:无此记录
	 */
	@Override
	public int updateBusiness(Business business) {
		boolean exist = businessDao.isExist(business.getName());
		if (exist == true) {
			//如果数据库中已有该记录则修改数据
			businessDao.updateBusiness(business);
			return 0;
		} else {
			//如果数据库中不存在则提示用户
			return 1;
		}
	}

	@Override
	public Business getBusinessByID(int id) {
		Business business = businessDao.getBusinessByID(id);
		return business;
	}

	@Override
	public List<Business> getBusinessesByName(String name) {
		List<Business> businesses = businessDao.getBusinessesByName(name);
		return businesses;
	}

	@Override
	public void deleteBusinessByID(int id) {
		businessDao.deleteBusinessByID(id);

	}

	@Override
	public List<Business> getBusinessesByPage(int firstResult, int maxResults) {
		List<Business> businesses = businessDao.getBusinessesByPage(firstResult, maxResults);
		return businesses;
	}

	@Override
	public int getCount() {
		int count = businessDao.getCount();
		return count;
	}

}
