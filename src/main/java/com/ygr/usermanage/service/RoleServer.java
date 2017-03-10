package com.ygr.usermanage.service;

import java.util.List;

import com.ygr.usermanage.model.Role;

public interface RoleServer {
	/**
	 * 添加一个角色
	 */
	boolean addRole(Role role);

	/**
	 * 查询所有角色信息
	 */
	List<Role> findAllRole();

	/**
	 * 删除角色通过ID
	 */
	void deleteRoleById(int role_id);

	/**
	 * 更新修改id
	 */
	void updateRole(Role role);

	/**
	 * 通过id查询一个角色信息
	 */
	Role findRoleById(int role_id);
}
