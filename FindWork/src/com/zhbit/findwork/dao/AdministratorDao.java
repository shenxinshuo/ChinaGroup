package com.zhbit.findwork.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zhbit.findwork.entity.Administrator;

public interface AdministratorDao {

	void addAdmin(Administrator admin);

	void deleteAdmin(int id);

	void updateAdmin(Administrator admin);

	boolean isExist(String adminName);

	List<Administrator> getAdminByName(String name);

	Administrator getAdminByNameAndPassword(String name,String password);
	
	Administrator getAdminByID(int id);

	SessionFactory getSessionFactory();

	void setSessionFactory(SessionFactory sessionFactory);

}