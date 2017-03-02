package com.ygr.usermanage.dao;

import com.ygr.usermanage.model.Role;

public interface RoleDao {
	
	public void addRole(Role role);
	
	public void deleteRoleById(int role_id);
	
	public void updateRole(Role role);
	
}
