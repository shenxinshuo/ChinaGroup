package com.zhbit.findwork.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Role;
import com.zhbit.findwork.service.RoleService;

public class RoleAction extends ActionSupport {
	
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	private Role role;
	private List<Role> roles;
	private String message;//提示信息
	private String errorMessage;//错误提示信息
	
	public void setRole(Role role) {
		this.role = role;
	}
	public Role getRole() {
		return role;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 添加角色表单验证
	 */
	public void validateAdd() {
		if (role.getName() == null || "".equals(role.getName())) {
			addFieldError("role.name", "角色名不能为空");
		}
	}
	/**'
	 * 添加role
	 * @return
	 */
	public String add() {
		int result = roleService.addRole(role);
		if (result == 0) {
			//数据库中已有该角色
			errorMessage = "数据库中已有该角色";
			return "showAdd";
		} else if (result == 1) {
			//插入成功
			message = "角色新增成功";
			roles = roleService.getAllRoles();
			return "showAllRoles";
		}
		return "showAllRoles";
//		System.out.println("add...");
//		return NONE;
	}
	
	

	/**
	 * 修改角色表单验证
	 */
	public void validateUpdate() {
		if (role.getName() == null || "".equals(role.getName())) {
			addFieldError("role.name", "角色名不能为空");
		}
	}
	/**
	 * 修改角色
	 * @return
	 */
	public String update() {
		return NONE;
	}
	
	/**
	 * 获取所有角色
	 * @return
	 */
	public String getAllRoles() {
//		roleService.g
		return NONE;
	}
	
	/**
	 * 删除角色
	 * @return
	 */
	public String delete() {
		return NONE;
	}
	
}
