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
	
	public String showUpdatePage() {
		role = roleService.getRoleByID(role.getId());
		return "showUpdatePage";
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
		int result = roleService.updateRole(role);
		System.out.println(111);
		if (result == 0) {
			//修改成功
			message = "修改成功";
			roles = roleService.getAllRoles();
			return "showAllRoles";
		} else if (result == 1) {
			//已存在
			errorMessage = "该角色已存在";
			return "showUpdatePage";
		}
		return "showUpdatePage";
	}
	
	/**
	 * 获取所有角色
	 * @return
	 */
	public String getAllRoles() {
		roles = roleService.getAllRoles();
		return "showAllRoles";
	}
	
	/**
	 * 删除角色
	 * @return
	 */
	public String delete() {
		roleService.deleteRoleByID(role.getId());
		message = "角色删除成功";
		roles = roleService.getAllRoles();
		return "showAllRoles";
	}
	
}
