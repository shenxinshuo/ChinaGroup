package com.zhbit.findwork.service;

import java.util.List;

import com.zhbit.findwork.entity.Role;

public interface RoleService {
	
	/**
	 * 新增角色
	 * @param role
	 */
	public int addRole(Role role);
	
	/**
	 * 修改角色信息
	 * @param role
	 */
	public int updateRole(Role role);
	
	/**
	 * 根据ID查询角色信息
	 * @param id
	 * @return
	 */
	public Role getRoleByID(int id);
	
	/**
	 * 根据角色名字查询角色信息（查询用）
	 * @param name
	 * @return
	 */
	public List<Role> getRolesByName(String name);
	
	/**
	 * 根据ID删除角色
	 * @param id
	 */
	public void deleteRoleByID(int id);
	
	/**
	 * 根据分页返回某一页的角色信息列表
	 * @param firstResult 要查询的第一条记录
	 * @param maxResults  页面大小
	 * @return
	 */
	public List<Role> getRoleByPage(int firstResult, int maxResults);
	
	/**
	 * 获取表中数据条数
	 * @return
	 */
	public int getCount();
}
