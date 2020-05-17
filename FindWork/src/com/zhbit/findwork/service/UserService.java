package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Collection_Business;
import com.zhbit.findwork.entity.User;

/**
 * 用户业务接口
 * @author 王德略
 * @description TODO
 * @date 2020年5月17日
 */
public interface UserService {
	/**
	 * 新增用户
	 * @param user
	 */
	public boolean addUser(User user);
	/**
	 * 新增企业收藏
	 * @param c_b
	 */
	public boolean addCollection_Business(Collection_Business c_b);
	/**
	 * 删除收藏的企业
	 * @param userid businessid
	 */
	public boolean deleteCollection_Business(int userid,int businessid);
	/**
	 * 查看收藏的企业
	 * @param userid
	 */
	public List<Business> getBusinessesByUserId(int userid);
	/**
	 * 修改用户信息
	 * @param user
	 */
	public boolean updateUser(User user);
	/**
	 * 根据ID查询用户信息
	 * @param id
	 * @return
	 */
	public User getUserByID(int id);
	/**
	 * 查询所有的用户（查询用）
	 * @param 
	 * @return
	 */
	public List<User> getAllUsers();
	/**
	 * 根据用户名查询用户（查询用）
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
	
	/**
	 * 根据ID删除用户
	 * @param id
	 */
	public boolean deleteUserByID(int id);
	
	/**
	 * 根据分页返回某一页的用户信息列表
	 * @param firstResult 要查询的第一条记录
	 * @param maxResults  页面大小
	 * @return
	 */
	public List<User> getUserByPage(int firstResult, int maxResults);
	
	/**
	 * 获取表中数据条数
	 * @return
	 */
	public int getCount();
}
