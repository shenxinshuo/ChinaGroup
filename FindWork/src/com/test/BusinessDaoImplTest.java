package com.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.dao.BusinessDao;
import com.zhbit.findwork.dao.RoleDao;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Role;

public class BusinessDaoImplTest {

	private static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsExist() {
		BusinessDao businessDao = (BusinessDao) context.getBean("businessDaoImpl");
		boolean exist = businessDao.isExist("阿里巴巴");
		System.out.println(exist);
	}

	@Test
	public void testAddBusiness() {
		BusinessDao businessDao = (BusinessDao) context.getBean("businessDaoImpl");
		Business business = new Business();
		business.setName("腾讯");
		business.setCity("马化腾");
		RoleDao roleDao = (RoleDao) context.getBean("roleDaoImpl");
		Role role = roleDao.getRoleByID(2);
		business.setRole(role);
		business.setCreate_at(new Date());
		business.setUpdate_at(new Date());
		businessDao.addBusiness(business);
	}

	@Test
	public void testUpdateBusiness() {
		BusinessDao businessDao = (BusinessDao) context.getBean("businessDaoImpl");
		Business business = businessDao.getBusinessByID(1);
		business.setPassword("mayu");
		businessDao.updateBusiness(business);
	}

	@Test
	public void testGetBusinessByID() {
		BusinessDao businessDao = (BusinessDao) context.getBean("businessDaoImpl");
		Business business = businessDao.getBusinessByID(1);
		System.out.println(business);
	}

	@Test
	public void testGetBusinessesByName() {
		BusinessDao businessDao = (BusinessDao) context.getBean("businessDaoImpl");
		List<Business> businesses = businessDao.getBusinessesByName("阿里巴巴");
		System.out.println(businesses);
	}

	@Test
	public void testDeleteBusinessByID() {
		BusinessDao businessDao = (BusinessDao) context.getBean("businessDaoImpl");
		businessDao.deleteBusinessByID(2);
	}

	@Test
	public void testGetBusinessesByPage() {
		BusinessDao businessDao = (BusinessDao) context.getBean("businessDaoImpl");
		List<Business> businesses = businessDao.getBusinessesByPage(0, 3);
		System.out.println(businesses);
	}

	@Test
	public void testGetCount() {
		BusinessDao businessDao = (BusinessDao) context.getBean("businessDaoImpl");
		int count = businessDao.getCount();
		System.out.println("数据表数据条数："+count);
	}
	
	/**
	 * 测试根据角色获取企业信息列表
	 */
	@Test
	public void testGetBusinessesByRole() {
		RoleDao roleDao = (RoleDao) context.getBean("roleDaoImpl");
		Role role = roleDao.getRoleByID(2);
		List<Business> businesses = role.getBusinesses();
		System.out.println(businesses);
	}

}
