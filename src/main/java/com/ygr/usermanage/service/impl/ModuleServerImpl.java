package com.ygr.usermanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ygr.usermanage.dao.ModuleDao;
import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.model.Module;
import com.ygr.usermanage.service.ModuleServer;

@Service("moduleServer")
@Scope("singleton")
public class ModuleServerImpl implements ModuleServer {
	@Autowired
	private ModuleDao moduleDao;

	@Override
	public boolean addModule(Module module) {
		if (null == moduleDao.getModuleBymodulename(module.getModulename())) {
			moduleDao.addModule(module);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Module> findAllModule() {
		return moduleDao.findAllModule();
	}

	@Override
	public void deleteModuleById(int module_id) {
		moduleDao.deleteModuleById(module_id);

	}

	@Override
	public void updateModule(Module module) {
		moduleDao.updateModule(module);
	}

	@Override
	public Module getModuleById(int module_id) {
		return moduleDao.getModuleById(module_id);
	}

	@Override
	public List<Function> getFunctionListsByModuleId(int module_id) {
		return moduleDao.getFunctionListsByModuleId(module_id);
	}

}
