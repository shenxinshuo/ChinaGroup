package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.dao.AdministratorDao;
import com.zhbit.findwork.entity.Administrator;

public interface AdministratorService {

	int addAdmin(Administrator admin);

	int updateAdmin(Administrator admin);

	void deleteAdmin(int id);

	Administrator getAdminByID(int id);

	List<Administrator> getAdminByName(String name);

	Administrator getAdminByNameAndPassword(String name,String password);
	
	AdministratorDao getAdminDao();

	void setAdminDao(AdministratorDao adminDao);

}