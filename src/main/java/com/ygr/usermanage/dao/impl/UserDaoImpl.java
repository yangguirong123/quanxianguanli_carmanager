package com.ygr.usermanage.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.ygr.usermanage.dao.UserDao;
import com.ygr.usermanage.model.User;
import com.ygr.usermanage.utils.MyHibernateDaoSupport;
@Transactional
@Repository("userDao")
@Scope("singleton")
public class UserDaoImpl extends MyHibernateDaoSupport implements UserDao {

	@Override
	public void addUser(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public List<User> findAllUser() {
		return (List<User>) getHibernateTemplate().find("FROM User");

	}

	@Override
	public void deleteUserById(int user_id) {
		User user = getHibernateTemplate().get(User.class, user_id);
		getHibernateTemplate().delete(user);
	}

	@Override
	public void updateUserById(User user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public User findUserById(int user_id) {
		
		return getHibernateTemplate().get(User.class, user_id);
	}

}
