package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.service.AdvertiseService;

public class AdvertiseServiceImplTest {
	private static ApplicationContext context;
	private static AdvertiseService advertiseService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		advertiseService = (AdvertiseService)context.getBean("advertiseServiceImpl");
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
	public void testAddAdvertese() {
		Advertise advertise = new Advertise();
		advertise.setBusinessName("李");
		advertise.setPostName("java");
		advertise.setEducationBackground("本科");
		advertise.setAsk("本科以上");
		advertise.setWantJoyType("实习");
		advertise.setLowWages(2500);
		advertise.setLargeWages(1500);
		advertise.setTitle("岗位");
		advertiseService.addAdvertese(advertise);
	}

	@Test
	public void testUpdateAdvertese() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdvertiseByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAdvertiseByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdvertiseDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAdvertiseDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdvertiseByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUnFinAdvertise() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdvertiseByPageWithCheck() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdvertiseByBidIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUnFinAdvertiseCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdvertiseCountByBidIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdvertiseCountByBidInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdvertiseByBidIntIntInt() {
		fail("Not yet implemented");
	}

}
