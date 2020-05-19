package com.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.dao.BusinessDao;
import com.zhbit.findwork.dao.RoleDao;
import com.zhbit.findwork.dao.UserDao;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.entity.User;

public class UserDaoImplTest {
	private static ApplicationContext context;
	private static UserDao userDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) context.getBean("userDaoImpl");
	}
	

	@Test
	public void testIsExist() {
		boolean exist = userDao.isExistbyName("王德略");
		System.out.println(exist);
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("王德略");
		user.setPassword("123456");
		user.setAddress("广东XXXXXX");
		RoleDao roleDao = (RoleDao) context.getBean("roleDaoImpl");
		Role role = roleDao.getRoleByID(1);
		user.setRole(role);
		userDao.addUser(user);
	}

	@Test
	public void testUpdateUser() {
		User user=userDao.getUserByID(1);
		user.setTelephone("1342170415");
		userDao.updateUser(user);
	}

	@Test
	public void testGetUserByID() {
		User user=userDao.getUserByID(1);
		System.out.println(user);
	}

	@Test
	public void testGetUserByName() {
		User user=(User)userDao.getUserByName("王德略");
		System.out.println(user);
	}
	@Test
	public void testGetAllUsers(){
		List<User> users=userDao.getAllUsers();
		System.out.println(users);
	}

	@Test
	public void testDeleteUserByID() {
		userDao.deleteUserByID(2);//删除成功标识变成1
	}

	@Test
	public void testGetUserByPage() {
		List<User> user=(List<User>)userDao.getUserByPage(0, 3);
		System.out.println(user);
	}

	@Test
	public void testGetCount() {
		int t=userDao.getCount();
		System.out.println(t);
	}
	/**
	 * 测试根据角色获取用户信息列表
	 */
	@Test
	public void testGetUserListByRole() {
		RoleDao roleDao = (RoleDao) context.getBean("roleDaoImpl");
		Role role = roleDao.getRoleByID(1);
		List<User> users = role.getUsers();
		System.out.println(users);
	}

}
