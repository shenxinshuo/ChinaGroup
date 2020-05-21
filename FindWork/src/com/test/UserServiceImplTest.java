package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.dao.RoleDao;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Collection_Business;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.BusinessService;
import com.zhbit.findwork.service.RoleService;
import com.zhbit.findwork.service.UserService;
import com.zhbit.findwork.service.impl.BusinessServiceImpl;

public class UserServiceImplTest {
	private static ApplicationContext context;
	private static UserService userService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService) context.getBean("userServiceImpl");
	}
	@Test
	public void testGetUserByNameAndPassword(){
		User user= userService.getUserByNameAndPassword("发", "123456");
		System.out.println(user);
	}
	@Test
	public void testIsExistName(){
		boolean flag=userService.isExistName("dfa");
		System.out.println(flag);
	}
	@Test
	public void testAddUser() {
		User user = new User();
		//user.setName("王德略"); 此用户存在，添加失败，返回false
		user.setName("小王2");//添加成功
		user.setPassword("123456");
		user.setAddress("广东XXXXXX");
		user.setTelephone("1234567895");
		RoleService roleService = (RoleService) context.getBean("roleServiceImpl");
		Role role = roleService.getRoleByID(1);
		user.setRole(role);
		boolean fla =userService.addUser(user);
		System.out.println(fla);
	}
	//测试收藏企业功能
	@Test
	public void testAddCollection_Business(){
		Collection_Business c_b = new Collection_Business();
		User user =userService.getUserByID(2);
		BusinessService businessService = (BusinessService) context.getBean("businessServiceImpl");
		//这里需要判断business是否能查询到
		Business business = businessService.getBusinessByID(3);	
		c_b.setUser(user);
		c_b.setBusiness(business);
		boolean t =userService.addCollection_Business(c_b);
		System.out.println(t);
	}
	//测试查看收藏企业功能
	@Test 
	public void testGetBusinessesByUserId(){
		List<Business> list=userService.getBusinessesByUserId(1);
		System.out.println(list.size());
	}
	//测试删除收藏企业
	@Test 
	public void testDeleteBusinessesByUserId(){
		userService.deleteCollection_Business(1, 8);
		
	}
	//按分页查询收藏企业
	@Test 
	public void testGetBusinessByPage(){
		List<Business> list=userService.getBusinessesByPage(2, 0, 1);
		System.out.println(list);
	}
	@Test
	public void testUpdateUser() {
		User user= userService.getUserByID(3);
		user.setName("小王2");
		user.setPassword("123");
		boolean fla =userService.updateUser(user);
		System.out.println(fla);
	}

	@Test
	public void testGetUserByID() {
		User user=	userService.getUserByID(3);
	   System.out.println(user);
	}
	@Test
	public void testGetUserByName() {
		User user=	userService.getUserByName("小王");
	   System.out.println(user);
	}
	
	@Test
	public void testGetAllUser() {
		List<User> users=userService.getAllUsers();
		System.out.println(users);
	}

	@Test
	public void testDeleteUserByID() {
		boolean fla= userService.deleteUserByID(4);
		System.out.println(fla);
	}

	@Test
	public void testGetUserByPage() {
		List<User> users=userService.getUserByPage(0, 3);
		System.out.println(users);
	}

	@Test
	public void testGetCount() {
		int t= userService.getCount();
		System.out.println(t);
	}

	@Test
	public void testGetUserDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserDao() {
		fail("Not yet implemented");
	}

}
