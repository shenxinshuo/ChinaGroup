package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhbit.findwork.entity.Post;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.PostService;
import com.zhbit.findwork.service.Post_typeService;
import com.zhbit.findwork.service.RoleService;

public class Post_typeServiceImplTest {

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
	public void testAddPost_type() {
		Post_typeService Post_typeService = (Post_typeService) context.getBean("post_typeService");
		PostService postService = (PostService) context.getBean("postService");
		Post_type pt1 = new Post_type();
		pt1.setPTname("运营");
		
//		Post_type pt2 = Post_typeService.getPost_typeByName("技术").get(0);
		
		Post p1 = new Post();
		p1.setPname("用户运营");
//		p1.setPtype(pt1);
		p1.setPtype(pt1);
	
		Post p2 = new Post();
		p2.setPname("产品运营");
		p2.setPtype(pt1);
		
		Post p3 = new Post();
		p3.setPname("新媒体运营");
		p3.setPtype(pt1);
		
		Post p4 = new Post();
		p4.setPname("运营总监");
		p4.setPtype(pt1);
		
		Post p5 = new Post();
		p5.setPname("编辑");
		p5.setPtype(pt1);
		
		Post p6 = new Post();
		p6.setPname("客服经理");
		p6.setPtype(pt1);
		
		pt1.getPosts().add(p1);
		pt1.getPosts().add(p2);
		pt1.getPosts().add(p3);
		pt1.getPosts().add(p4);
		pt1.getPosts().add(p5);
		pt1.getPosts().add(p6);

		
//		pt1.getPosts().add(p1);
//		pt1.getPosts().add(p2);
		
		Post_typeService.addPost_type(pt1);
		
		postService.addPost(p1);
		postService.addPost(p2);
		postService.addPost(p3);
		postService.addPost(p4);
		postService.addPost(p5);
		postService.addPost(p6);
		
		
		
	
		
//		Post_typeService.updatePost_type(pt2);
		
//		
//		Post p3 = new Post();
//		p3.setPname("Web前端");
//		p3.setPtype(pt1);
//		
//		Post p4 = new Post();
//		p4.setPname("数据挖掘");
//		p4.setPtype(pt1);
//		
//		Post p5 = new Post();
//		p5.setPname("C++");
//		p5.setPtype(pt1);
//		
//		Post p6 = new Post();
//		p6.setPname("Python");
//		p6.setPtype(pt1);
//		
//		pt1.getPosts().add(p1);
//		pt1.getPosts().add(p2);
//		pt1.getPosts().add(p3);
//		pt1.getPosts().add(p4);
//		pt1.getPosts().add(p5);
//		pt1.getPosts().add(p6);
//		
//		postService.addPost(p1);
//		postService.addPost(p2);
//		postService.addPost(p3);
//		postService.addPost(p4);
//		postService.addPost(p5);
//		postService.addPost(p6);
//		Post_typeService.addPost_type(pt1);
		
//		Post_type pt1 = new Post_type();
//		pt1.setPTname("运营");
//		
//		Post p1 = new Post();
//		p1.setPname("用户运营");
//		p1.setPtype(pt1);
//		
//		Post p2 = new Post();
//		p2.setPname("产品运营");
//		p2.setPtype(Post_typeService.getPost_typeByName("运营").get(0));
//		
//		Post p3 = new Post();
//		p3.setPname("新媒体运营");
//		p3.setPtype(Post_typeService.getPost_typeByName("运营").get(0));
//		
//		Post p4 = new Post();
//		p4.setPname("运营总监");
//		p4.setPtype(Post_typeService.getPost_typeByName("运营").get(0));
//		
//		Post p5 = new Post();
//		p5.setPname("编辑");
//		p5.setPtype(Post_typeService.getPost_typeByName("运营").get(0));
//		
//		Post p6 = new Post();
//		p6.setPname("客服经理");
//		p6.setPtype(Post_typeService.getPost_typeByName("运营").get(0));
		
//		Post_typeService.addPost_type(pt1);
//		postService.addPost(p1);
//		postService.addPost(p2);
//		postService.addPost(p3);
//		postService.addPost(p4);
//		postService.addPost(p5);
////		postService.addPost(p1);
//		postService.addPost(p6);
		
	}

	@Test
	public void testUpdatePost_type() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePost_type() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPost_typeByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPost_typeByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPost_typeDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPost_typeDao() {
		fail("Not yet implemented");
	}

}
