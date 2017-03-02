package com.ygr.usermanage.dao;

import java.util.List;

import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.model.Module;

public interface ModuleDao {
	
	void addModule(Module module);
	
	List<Module> findAllModule();
	
	void deleteModuleById(int module_id);
	
	void updateModule(Module module);
	
	Module getModuleById(int module_id);
	
	List<Function> getFunctionListsByModule( int module_id);
}
