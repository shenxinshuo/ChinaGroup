package com.zhbit.findwork.service.impl;

import java.util.List;

import com.zhbit.findwork.dao.BusinessDao;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.BusinessService;
import com.zhbit.findwork.service.RoleService;


/**
 * 企业业务接口实现类
 * @author SX
 * @description TODO
 * @date 2020年5月16日
 */
public class BusinessServiceImpl implements BusinessService {
	
	private BusinessDao businessDao;
	private RoleService roleService;
	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	/**
	 * 调用该接口时将名字和密码传入
	 * 然后判断返回的business对象是否为空即可
	 */
	@Override
	public Business login(String name, String password) {
		List<Business> businesses = businessDao.getBusinessByNameAndPassword(name, password);
		Business business = businesses.size() == 0 ? null : businesses.get(0);
		return business;
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
		//List<Role> roles = roleService.getRolesByName("企业");
		Role role = roleService.getRoleByID(2);
		business.setRole(role);
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
		List<Business> businessesInDB = (List<Business>) businessDao.getBusinessesByNameInAll(business.getName());
		Business businessInDB = businessDao.getBusinessByID(business.getId());
		
		if (businessesInDB.size() == 0) {
			//说明数据库中这个名字没人用，也证明企业修改了自己的名字 执行修改
			this.setBusinessForUpdate(businessInDB, business);
			businessDao.updateBusiness(businessInDB);
			return 0;
		} else {
			if (business.getId() == businessesInDB.get(0).getId()) {
				//说明要修改信息的企业没有修改名字，修改了别的字段 执行修改
				this.setBusinessForUpdate(businessInDB, business);
				businessDao.updateBusiness(businessInDB);
				return 0;
			} else {
				return 1;
			}
		}
	}
	//修改企业的辅助方法
	private void setBusinessForUpdate(Business b1, Business b2) {
		b1.setName(b2.getName());
		b1.setProvince(b2.getProvince());
		b1.setCity(b2.getCity());
		b1.setTelephone(b2.getTelephone());
		b1.setEmail(b2.getEmail());
		b1.setLicense_path(b2.getLicense_path() == null ? b1.getLicense_path() : b2.getLicense_path());
		b1.setAddress(b2.getAddress());
		b1.setDescription(b2.getDescription());
		b1.setUrl(b2.getUrl());
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
	public List<Business> getBusinessesByPageWithCheck(int firstResult, int maxResults, int check_flag) {
		List<Business> businesses = businessDao.getBusinessesByPageWithCheck(firstResult, maxResults, check_flag);
		return businesses;
	}
	
	@Override
	public void updateBusinessCheckFlag(Business business) {
		Business businessInDB = businessDao.getBusinessByID(business.getId());
		businessInDB.setCheck_flag(business.getCheck_flag());
		businessInDB.setComment(business.getComment());
		businessDao.updateBusiness(businessInDB);
		return ;
	}

	@Override
	public int getCountByCheckFlag(int flag) {
		int count = businessDao.getCountByCheckFlag(flag);
		return count;
	}
	@Override
	public int getCount() {
		int count = businessDao.getCount();
		return count;
	}
	
	@Override
	public List<Business> getBusinessesByNameSearch(int firstResult, int maxResults, String name) {
		List<Business> businesses = businessDao.getBusinessesByNameSearch(firstResult, maxResults, name);
		return businesses;
	}
	
	@Override
	public int getCountByNameSearch(String name) {
		int count = businessDao.getCountByNameSearch(name);
		return count;
	}

}
