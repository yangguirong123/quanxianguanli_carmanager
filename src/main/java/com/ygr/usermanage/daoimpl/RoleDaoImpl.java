package com.ygr.usermanage.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.ygr.usermanage.dao.RoleDao;
import com.ygr.usermanage.model.Role;
@Transactional
@Repository("roleDao")
@Scope("singleton")
public class RoleDaoImpl implements RoleDao {
	
	@Override
	public void addRole(Role role) {
		
	}

	@Override
	public void deleteRoleById(int role_id) {
		
	}

	@Override
	public void updateRole(Role role) {
			
	}

}
