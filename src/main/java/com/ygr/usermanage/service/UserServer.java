package com.ygr.usermanage.server;

import java.util.List;

import com.ygr.usermanage.model.User;

public interface UserServer {
	/**
	 * 添加一个用户账号
	 */
	boolean addUser(User user);

	/**
	 * 查询所有用户
	 */
	List<User> findAllUser();

	/**
	 * 通过ID删除用户
	 */
	void deleteUserById(int user_id);

	/**
	 * 更新修改用户密码
	 */
	void updateUserById(User user);

	/**
	 * 通过id获取一个用户信息
	 */
	User findUserById(int user_id);

}
