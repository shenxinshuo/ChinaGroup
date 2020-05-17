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

import com.zhbit.findwork.dao.RoleDao;

import com.zhbit.findwork.entity.Role;

public class RoleDaoImplTest {

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
	public void testAddRole() {
	
	}

	@Test
	public void testIsExist() {
		RoleDao roleDao = (RoleDao) context.getBean("roleDaoImpl");
		String roleName = "«Û÷∞’ﬂ";
		boolean exist = roleDao.isExist(roleName);
		System.out.println(exist);
	}

	@Test
	public void testUpdateRole() {
		RoleDao roleDao = (RoleDao) context.getBean("roleDaoImpl");
		Role role = roleDao.getRoleByID(3);
		role.setUpdate_at(new Date());
		roleDao.updateRole(role);
	}

	@Test
	public void testDeleteRole() {
		RoleDao roleDao = (RoleDao) context.getBean("roleDaoImpl");
//		Role role = new Role();
//		role.setId(3);
		roleDao.deleteRole(3);
	}

	@Test
	public void testGetRoleByID() {
		RoleDao roleDao = (RoleDao) context.getBean("roleDaoImpl");
		Role role = roleDao.getRoleByID(3);
		System.out.println(role);
	}

	@Test
	public void testGetRolesByPage() {
		RoleDao roleDao = (RoleDao) context.getBean("roleDaoImpl");
		List<Role> roles = roleDao.getRolesByPage(0, 2);
		System.out.println(roles);
	}

	@Test
	public void testGetCount() {
		RoleDao roleDao = (RoleDao) context.getBean("roleDaoImpl");
		int count = roleDao.getCount();
		System.out.println(count);
	}

}
