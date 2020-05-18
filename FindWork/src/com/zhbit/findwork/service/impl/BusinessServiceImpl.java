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
	 * 2:企业密码和确认密码不一致
	 */
	@Override
	public int addBusiness(Business business) {
		//判断用户传过来的密码和确认密码是否一致
		if (!(business.getPassword().equals(business.getConfirmPassword()))) {
			return 2;
		}
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
	 * 1:名字已被占用
	 */
	@Override
	public int updateBusiness(Business business) {
		List<Business> businessesInDB = (List<Business>) businessDao.getBusinessesByName(business.getName());
		if (businessesInDB.size() == 0) {
			//说明数据库中这个名字没人用，也证明企业修改了自己的名字 执行修改
			businessDao.updateBusiness(business);
			return 0;
		} else {
			if (business.getId() == businessesInDB.get(0).getId()) {
				//说明要修改信息的企业没有修改名字，修改了别的字段 执行修改
				businessDao.updateBusiness(business);
				return 0;
			} else {
				return 1;
			}
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
