package com.ygr.usermanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ygr.usermanage.dao.RoleDao;
import com.ygr.usermanage.dao.UserDao;
import com.ygr.usermanage.model.Role;
import com.ygr.usermanage.model.User;
import com.ygr.usermanage.service.UserServer;

@Service("userServer")
@Scope("singleton")
public class UserServerImpl implements UserServer {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public void deleteUserById(int user_id) {
		userDao.deleteUserById(user_id);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public User findUserById(int user_id) {
		return userDao.findUserById(user_id);
	}

	@Override
	public User findUserByusername(String username) {
		return userDao.findUserByUsername(username);
	}

	// 如果去数据库查询这个用户存在 ，那么就判断他的state是否等于2
	// 等于2说明是审核通过的用户，不等于2说明不是审核通过的返回为null
	@Override
	public User login(User user) {
		User u = userDao.findUserByUsername(user.getUsername());
		if (null != u) {
			int state = u.getState();
			if (state == 2 && user.getUsername().equals(u.getUsername())
					&& user.getPassword().equals(u.getPassword())) {
				return u;
			} else {
				return null;
			}
		}
		return null;

	}

	@Override
	public void verifyUser(User user, int role_Id) {
		if (user.getState() == 2) {
			Role role = roleDao.findRoleById(role_Id);
			user.setRole(role);
			userDao.updateUser(user);
		}
	}

}
