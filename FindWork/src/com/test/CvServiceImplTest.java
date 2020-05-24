package com.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.Id;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.CvService;
import com.zhbit.findwork.service.UserService;

public class CvServiceImplTest {
	private static ApplicationContext context;
	private static CvService cvService;
	private static AdvertiseService advertiseService;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		cvService = (CvService)context.getBean("cvServiceImpl");
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
	public void testGetCvDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCvDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCv() {
		Cv cv = new Cv();
		cv.setName("段世平2");
		cv.setTelephone("13116865902");
		cv.setEducation_background("本科");
		cv.setSelf("good");
		cv.setPolitics_status("团员");
		cv.setSkill("打球");
		cv.setExperience("无");
		cv.setLive_province("广东");
		cv.setWant_joy_type("java");
		cv.setLive_city("珠海");
		cv.setWant_province("江西");
		cv.setWant_city("樟树");
		cv.setWant_low_wages(2500);
		cv.setWant_large_wages(15000);
		cv.setWant_post("java");
		//cv.setSelf_appraisal("goodluck51");
		UserService userService = (UserService)context.getBean("userServiceImpl");
		AdvertiseService advertiseService = (AdvertiseService)context.getBean("advertiseServiceImpl");
		Advertise advertise = advertiseService.getAdvertiseByID(1);
		cv.getAdvertises().add(advertise);
		cv.setUser(userService.getUserByID(3));
		cvService.addCv(cv);
	}

	@Test
	public void testUpdate() {
		Cv cv = new Cv();
		cv.setId(1);
		cv.setName("段世平");
		cvService.updateCv(cv);
	}
	@Test
	public void textGetCvListByUserId(){
		List<Cv> cvs=cvService.getCvListByUserId(1);
		System.out.println(cvs);
		System.out.println(cvs.size());
	}
	@Test
	public void testGetCvByID() {
		Cv cv = cvService.getCvByID(1);
		System.out.println(cv);
	}

	@Test
	public void testDeleteCvByID() {
		cvService.deleteCvByID(2);
	}

	@Test
	public void testGetCvByName() {
		Cv cv = cvService.getCvByName("段世平");
		System.out.println(cv);
	}

}
