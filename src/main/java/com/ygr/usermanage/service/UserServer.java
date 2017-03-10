package com.ygr.usermanage.service;

import java.util.List;

import com.ygr.usermanage.model.User;

public interface UserServer {
	/**
	 * 注册一个用户账号 true 表示申请成功 false 用户已经存在重新申请
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
	 * 通过id获取一个用户信息
	 */
	User findUserById(int user_id);
	/**
	 * 通过username获取一个用户信息
	 */
	User findUserByusername(String  username);
	/**
	 * 登录用户，判断state是否为2
	 */
	User login(User user);

	/**
	 *管理员审核用户并赋予账户对应角色
	 */
	void verifyUser(User user, int role_Id);
}
