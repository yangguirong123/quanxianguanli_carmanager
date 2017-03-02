package com.ygr.usermanage.model;

import java.util.Set;

public class Module {
	private int module_id;// 模块id
	private String modulename;// 模块名称
	private String description;// 模块描述
	private Set<Function> functionLists;// 持有功能集合

	public Module(String modulename, String description) {
		this.modulename = modulename;
		this.description = description;
	}
	public Module(){
		
	}
	public int getModule_id() {
		return module_id;
	}

	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Function> getFunctionLists() {
		return functionLists;
	}

	public void setFunctionLists(Set<Function> functionLists) {
		this.functionLists = functionLists;
	}

	@Override
	public String toString() {
		return "Modules [modulename=" + modulename + ", description=" + description + ", functionLists=" + functionLists + "]";
	}

}
