package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.entity.Advertisement;
import com.zhbit.findwork.service.AdvertisementService;
import com.zhbit.findwork.service.impl.AdvertisementServiceImpl;

public class AdvertisementServiceImplTest extends AdvertisementServiceImpl {
	private static ApplicationContext context;
	private static AdvertisementService  advertisementService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		advertisementService = (AdvertisementService) context.getBean("advertisementServiceImpl");	
	}
	
	@Test
	public void testAddAD() {
		Advertisement ad= new Advertisement();
		ad.setId(3);
		ad.setTopic("测试2");
		ad.setCost("100");
		advertisementService.addAD(ad);
	}
	@Test
	public void testGetAdvertisementById(){
		Advertisement ad =advertisementService.getAdvertisementById(1);
		System.out.println(ad.getTopic());
	}
	@Test
	public void testChangeAD(){
		Advertisement ad =advertisementService.getAdvertisementById(1);
		ad.setTopic("更改标题2");
		advertisementService.changeAD(ad);		
	}
	@Test
	public void testDeleteAD(){
		advertisementService.deleteAD(1);
	}
	@Test
	public void testgetAllAdvertisements(){
		List<Advertisement> ads=advertisementService.getAllAdvertisements();
		System.out.println(ads.get(0).getTopic());
	}

}
