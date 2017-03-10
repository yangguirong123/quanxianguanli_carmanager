package com.ygr.usermanage.model;

public class User {
	private int user_id;
	private String username;
	private String password;
	private int state;
	private Role role;

	public User() {
	}
	
	public User(String username, String password, int state) {

		this.username = username;
		this.password = password;
		this.state = state;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", state=" + state + ", role=" + role + "]";
	}

	
}
