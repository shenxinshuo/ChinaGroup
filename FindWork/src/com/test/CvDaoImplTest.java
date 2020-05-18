package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.dao.CvDao;
import com.zhbit.findwork.dao.UserDao;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.entity.User;

public class CvDaoImplTest {
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
	public void testSetSessionFactory() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCv() {
		CvDao cvDao = (CvDao)context.getBean("cvDaoImpl");
		Cv cv = new Cv();
		cv.setName("段世平");
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
		UserDao userDao = (UserDao)context.getBean("userDaoImpl");
		User user = userDao.getUserByID(1);
		cv.setUser(user);
		cvDao.addCv(cv);
	}

	@Test
	public void testUpdateCv() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCvByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCvByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCvListByName() {
		fail("Not yet implemented");
	}

}
