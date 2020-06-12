package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.BlackListService;
import com.zhbit.findwork.service.BusinessService;
import com.zhbit.findwork.service.UserService;

public class BlackListServiceImplTest {
	private static ApplicationContext context;
	private static BlackListService blackListService;
	private static UserService userService;
	private static BusinessService businessService;
	private static AdvertiseService advertiseService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		blackListService = (BlackListService) context.getBean("blackListServiceImpl");
		userService = (UserService) context.getBean("userServiceImpl");
		businessService = (BusinessService) context.getBean("businessServiceImpl");
		advertiseService = (AdvertiseService)context.getBean("advertiseServiceImpl");
	
	}
	@Test
	public void testAddBusinessToBlackList() {
		User user =userService.getUserByID(2);
		Business business=businessService.getBusinessByID(12);
		//把当前用户和该用户举报的企业加入黑名单表
		String hh="jjjj";
		boolean bl=blackListService.addBusinessToBlackList(user, business,hh);
		System.out.println(bl);
	}
	@Test
	public void testAddAdvertiseToBlackList(){
		String hh="jjjj";
		User user =userService.getUserByID(2);
		Advertise advertise =advertiseService.getAdvertiseByID(4);
		boolean bl =blackListService.addAdvertiseToBlackList(user, advertise,hh);
		System.out.println(bl);
	}
	@Test
	public void testGetAllBusinesses(){
		List<Business> lb=blackListService.getAllBusinesses();
		System.out.println(lb.size());
		for(int i=0;i<lb.size();i++){
			System.out.println(lb.get(i).getName());
		}
	}
	@Test
	public void testGetAllAdvertises(){
		List<Advertise> lb=blackListService.getAllAdvertises();
		System.out.println(lb.size());
		for(int i=0;i<lb.size();i++){
			System.out.println(lb.get(i).getTitle());
		}
	}
	@Test
	public void testComplainsBusinessOfSuccess(){

		blackListService.complainsBusinessOfSuccess(5);
	}
	@Test
	public void testComplainsBusinessOfFaile(){
		blackListService.complainsBusinessOfFaile(5);
	}
	@Test
	public void testComplainsAdvertiseOfSuccess(){
		blackListService.complainsAdvertiseOfSuccess(4);
	}
	@Test
	public void testComplainsAdvertiseOfFaile(){
		blackListService.complainsAdvertiseOfFaile(3);
	}
}
