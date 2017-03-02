package com.ygr.usermanage.model;

import java.util.Set;

public class Role {
	private int role_id;// 角色ID
	private String rolename;// 角色名
	private String description;// 角色描述
	private Set<Function> functionList;// 持有功能的集合

	public Role(String rolename, String description) {
		this.rolename = rolename;
		this.description = description;
	}

	public Role() {
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Function> getFunctionList() {
		return functionList;
	}

	public void setFunctionList(Set<Function> functionList) {
		this.functionList = functionList;
	}

	@Override
	public String toString() {
		return "Roles [rolename=" + rolename + ", description=" + description + ", functionList=" + functionList + "]";
	}

}
