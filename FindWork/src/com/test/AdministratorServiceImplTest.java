package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.entity.Administrator;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.AdministratorService;
import com.zhbit.findwork.service.PostService;
import com.zhbit.findwork.service.RoleService;

public class AdministratorServiceImplTest {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	public void setContext(ApplicationContext context) {
		this.context = context;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testAddAdmin() {
		
		AdministratorService adminService = (AdministratorService) context.getBean("adminService");
		RoleService roleService = (RoleService) context.getBean("roleServiceImpl");
		Administrator admin = new Administrator();
		admin.setAccount("admin");
		admin.setPassword("12345678");
		
		Role role = roleService.getRolesByName("π‹¿Ì‘±").get(0);
		admin.setRole(role);
		
		adminService.addAdmin(admin);
	}

	@Test
	public void testUpdateAdmin() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAdmin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdminByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdminByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdminDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAdminDao() {
		fail("Not yet implemented");
	}

}
