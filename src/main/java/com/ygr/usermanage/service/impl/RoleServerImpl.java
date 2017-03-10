package com.ygr.usermanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ygr.usermanage.dao.RoleDao;
import com.ygr.usermanage.model.Role;
import com.ygr.usermanage.service.RoleServer;

@Service("roleServer")
@Scope("singleton")
public class RoleServerImpl implements RoleServer {

	@Autowired
	private RoleDao roleDao;

	@Override
	public boolean addRole(Role role) {
		if (null == roleDao.findRoleByRoleName(role.getRolename())) {
			roleDao.addRole(role);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Role> findAllRole() {
		return roleDao.findAllRole();
	}

	@Override
	public void deleteRoleById(int role_id) {
		roleDao.deleteRoleById(role_id);

	}

	@Override
	public void updateRole(Role role) {
		roleDao.updateRole(role);

	}

	@Override
	public Role findRoleById(int role_id) {
		return roleDao.findRoleById(role_id);
	}

}
