package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.RoleService;

public class RoleServiceImplTest {
	
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
	public void testAddRole() {
		RoleService roleService = (RoleService) context.getBean("roleServiceImpl");
		Role role = new Role();
		role.setName("管理员");
		roleService.addRole(role);
	}

	@Test
	public void testUpdateRole() {
		RoleService roleService = (RoleService) context.getBean("roleServiceImpl");
		Role role = roleService.getRoleByID(5);
		role.setComment("管理员角色");
		int result = roleService.updateRole(role);
		System.out.println(result);
	}

	@Test
	public void testGetRoleByID() {
		RoleService roleService = (RoleService) context.getBean("roleServiceImpl");
		Role role = roleService.getRoleByID(1);
		System.out.println(role);
	}

	@Test
	public void testGetRolesByName() {
		RoleService roleService = (RoleService) context.getBean("roleServiceImpl");
		List<Role> roles = roleService.getRolesByName("企业");
		for (Role role : roles) {
			System.out.println(role);
		}
//		for(int i=0; i<roles.size(); i++) {
//			System.out.println(roles.get(i));
//		}
	}

	@Test
	public void testDeleteRoleByID() {
		RoleService roleService = (RoleService) context.getBean("roleServiceImpl");
		roleService.deleteRoleByID(5);
	}

	@Test
	public void testGetRoleByPage() {
		RoleService roleService = (RoleService) context.getBean("roleServiceImpl");
		List<Role> roles = roleService.getRoleByPage(0, 3);
		for(Role role : roles) {
			System.out.println(role);
		}
	}

	@Test
	public void testGetCount() {
		RoleService roleService = (RoleService) context.getBean("roleServiceImpl");
		int count = roleService.getCount();
		System.out.println(count);
	}

}
