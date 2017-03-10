package com.ygr.usermanage.dao;

import java.util.List;

import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.model.Module;

public interface ModuleDao {
	/**
	 * 添加一个模块
	 */
	void addModule(Module module);
	/**
	 * 查询所有模块
	 */
	List<Module> findAllModule();
	/**
	 * 删除一个模块
	 */
	void deleteModuleById(int module_id);
	/**
	 * 更新一个模块
	 */
	void updateModule(Module module);
	/**
	 * 根据模块id获取模块信息
	 */
	Module getModuleById(int module_id);
	/**
	 * 根据模块名称获取模块信息
	 */
	Module getModuleBymodulename(String modulename);
	/**
	 * 根据一个模块id查询该模块下所有功能的信息list
	 */
	List<Function> getFunctionListsByModuleId( int module_id);
}
