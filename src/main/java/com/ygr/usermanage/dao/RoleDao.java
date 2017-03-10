package com.ygr.usermanage.dao;

import java.util.List;

import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.model.Role;

public interface RoleDao {
	/**
	 * 添加一个角色
	 */
	void addRole(Role role);

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
	 * 根据id查询一个角色信息
	 */
	Role findRoleById(int role_id);
	
	/**
	 * 根据id查询一个角色信息
	 */
	Role findRoleByRoleName(String  rolename);
	

}
