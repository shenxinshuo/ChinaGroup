package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.dao.Post_typeDao;
import com.zhbit.findwork.entity.Post_type;

public interface Post_typeService {

	int addPost_type(Post_type pt);

	int updatePost_type(Post_type pt);

	void deletePost_type(int id);

	Post_type getPost_typeByID(int id);

	List<Post_type> getAllPost_type();
	
	List<Post_type> getPost_typeByName(String name);

	Post_typeDao getPost_typeDao();

	void setPost_typeDao(Post_typeDao post_typeDao);

}