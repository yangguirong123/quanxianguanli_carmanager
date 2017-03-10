package com.ygr.usermanage.dao;

import java.util.List;

import com.ygr.usermanage.model.User;

public interface UserDao {
	/**
	 * 添加一个用户账号
	 */
	void addUser(User user);

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
	void updateUser(User user);

	/**
	 * 通过用户id查找用户信息
	 */

	User findUserById(int user_id);
	/**
	 * 通过用户名查找用户
	 */
	User findUserByUsername(String  username);
}
