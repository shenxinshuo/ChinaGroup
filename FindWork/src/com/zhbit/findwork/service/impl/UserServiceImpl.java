package com.zhbit.findwork.service.impl;

import java.util.List;

import com.zhbit.findwork.dao.UserDao;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.UserService;
/**
 * 用户业务接口实现类
 * @author 王德略
 * @description TODO
 * @date 2020年5月17日
 */
public class UserServiceImpl implements UserService{
	//注入UserDao
	private UserDao userDao;
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		//如果用户名存在，在添加失败
		if(userDao.isExistbyName(user.getName()))
			return false;
		else{
			userDao.addUser(user);
			return true;
		}
		
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		//如果用户名存在数据库
		if(userDao.isExistbyName(user.getName())){
			//判断此用户名是否原本的用户名
			if(user.getId()!=userDao.getUserByName(user.getName()).getId()){
				//如果不是原本用户名，更新失败
				return false;
			}
			//如果用户名是原来的用户名，更新成功
			userDao.updateUser(user);
			return true;
		}
		else{
			//用户名不在数据，更新成功
			userDao.updateUser(user);
			return true;	
		}
	}

	@Override
	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		//使用这个方法需要判断用户是否为空，因为有可能返回null
		return userDao.getUserByID(id);
	
	}
	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		//有可能返回空链表，需要判断链表长度是否为0
		return userDao.getAllUsers();
	}
	
	@Override
	public boolean deleteUserByID(int id) {
		// TODO Auto-generated method stub
		//判断此id是否有用户，否则删除失败
		if(userDao.getUserByID(id)!=null){
			userDao.deleteUserByID(id);
			return true;
		}
		else
			return false;
			
	}

	@Override
	public List<User> getUserByPage(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return userDao.getUserByPage(firstResult, maxResults);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return userDao.getCount();
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
