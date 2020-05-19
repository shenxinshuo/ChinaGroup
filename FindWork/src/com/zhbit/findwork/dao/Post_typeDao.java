package com.zhbit.findwork.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zhbit.findwork.entity.Post_type;

public interface Post_typeDao {

	void addPost_type(Post_type pt);

	void deletePost_type(int id);

	void updatePost_type(Post_type pt);

	boolean isExist(String post_typeName);
	
	List<Post_type> getPost_typeByName(String name);
	
	List<Post_type> getAllPost_type();
	
	Post_type getPost_typeByID(int id);

	SessionFactory getSessionFactory();

	void setSessionFactory(SessionFactory sessionFactory);

}