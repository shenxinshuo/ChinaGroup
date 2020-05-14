package com.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.dao.RoleDao;
import com.zhbit.findwork.dao.impl.RoleDaoImpl;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.RoleService;
import com.zhbit.findwork.service.impl.RoleServiceImpl;

public class RoleServiceImplTest {
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
		Role role = new Role();
		role.setName("π‹¿Ì‘±");
		Date create_at = new Date();
		role.setCreate_at(create_at);
		role.setUpdate_at(create_at);
		//RoleDao roleDao = (RoleDaoImpl)context.getBean("roleDaoImpl");
		RoleService roleService = (RoleService)context.getBean("roleServiceImpl");
		
		roleService.addRole(role);
	}

}
