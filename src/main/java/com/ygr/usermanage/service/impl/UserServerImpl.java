package com.ygr.usermanage.serverimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ygr.usermanage.dao.UserDao;
import com.ygr.usermanage.model.User;
import com.ygr.usermanage.server.UserServer;

@Service("userServer")
@Scope("singleton")
public class UserServerImpl implements UserServer {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean addUser(User user) {
		if (null == userDao.findUserById(user.getUser_id())) {
			userDao.addUser(user);
			return true;
		} else {
			return false;
		}

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
	public void updateUserById(User user) {
		userDao.updateUserById(user);
	}

	@Override
	public User findUserById(int user_id) {
		return userDao.findUserById(user_id);
	}

}
