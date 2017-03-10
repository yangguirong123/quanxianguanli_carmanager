package com.ygr.usermanage.dao.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ygr.usermanage.dao.RoleDao;
import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.model.Role;
import com.ygr.usermanage.utils.MyHibernateDaoSupport;

@Transactional
@Repository("roleDao")
@Scope("singleton")
public class RoleDaoImpl extends MyHibernateDaoSupport implements RoleDao {

	@Override
	public void addRole(Role role) {
		getHibernateTemplate().save(role);

	}

	@Override
	public List<Role> findAllRole() {
		return (List<Role>) getHibernateTemplate().find("FROM Role");

	}

	@Override
	public void deleteRoleById(int role_id) {
		Role role = getHibernateTemplate().get(Role.class, role_id);
		getHibernateTemplate().delete(role);
	}

	@Override
	public void updateRole(Role role) {
		getHibernateTemplate().update(role);
	}

	@Override
	public Role findRoleById(int role_id) {
		return getHibernateTemplate().get(Role.class, role_id);
	}

	@Override
	public Role findRoleByRoleName(String rolename) {
		List<Role> list = (List<Role>) getHibernateTemplate().find("From Role where rolename=?", rolename);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}	

}
