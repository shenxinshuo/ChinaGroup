package com.zhbit.findwork.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zhbit.findwork.entity.Post;

public interface PostDao {

	void addPost(Post p);

	void deletePost(int id);

	void updatePost(Post p);

	boolean isExist(String postName);
	
	List<Post> getPostByName(String name);
	
	Post getPostByID(int id);

	SessionFactory getSessionFactory();

	void setSessionFactory(SessionFactory sessionFactory);

}