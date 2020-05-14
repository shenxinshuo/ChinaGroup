package com.zhbit.findwork.service.impl;



import com.zhbit.findwork.dao.RoleDao;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.RoleService;


public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao;
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	
	@Override
	public void addRole(Role role) {
		
			roleDao.addRole(role);
		
	}

}
