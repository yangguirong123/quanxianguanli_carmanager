package com.ygr.usermanage.model;

import java.util.Set;

public class Function {
	private int function_id;
	private String code;
	private String description;
	private Module module;
	private Set<Role> roleLists;

	public Function(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public Function() {
	}

	public int getFunction_id() {
		return function_id;
	}

	public void setFunction_id(int function_id) {
		this.function_id = function_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Set<Role> getRoleLists() {
		return roleLists;
	}

	public void setRoleLists(Set<Role> roleLists) {
		this.roleLists = roleLists;
	}

	@Override
	public String toString() {
		return "Function [function_id=" + function_id + ", code=" + code + ", description=" + description +"]";
	}

}
