package com.zhbit.findwork.dao;

import java.util.List;

import com.zhbit.findwork.entity.Role;

/**
 * RoleDao接口
 * @author 沈鑫烁
 *
 */
public interface RoleDao {
	
	public void addRole(Role role);
	
	/**
	 * 根据角色名判断该角色是否存在
	 * @param roleName
	 * @return
	 */
	public boolean isExist(String roleName);
	
	/**
	 * 修改角色
	 * @param role
	 */
	public void updateRole(Role role);
	
	/**
	 * 删除角色
	 * @param role
	 */
	public void deleteRole(int id);
	
	/**
	 * 根据ID获取Role
	 * @param id
	 * @return
	 */
	public Role getRoleByID(int id);
	
	/**
	 * 根据角色名获取role
	 * @param name
	 * @return
	 */
	public List<Role> getRolesByName(String name);
	/**
	 * 获取分页需要的角色列表
	 * @param firstResult 要查询的第一条记录
	 * @param maxResults  页面大小
	 * @return
	 */
	public List<Role> getRolesByPage(int firstResult, int maxResults);
	
	/**
	 * 获取表中的数据条数
	 * @return
	 */
	public int getCount();
	
	

}
