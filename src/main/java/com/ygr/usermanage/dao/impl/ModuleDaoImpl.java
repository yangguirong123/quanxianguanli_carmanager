package com.ygr.usermanage.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ygr.usermanage.dao.ModuleDao;
import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.model.Module;
import com.ygr.usermanage.utils.MyHibernateDaoSupport;
import com.ygr.usermanage.utils.MyUtils;

@Transactional
@Repository("moduleDao")
@Scope("singleton")
public class ModuleDaoImpl extends MyHibernateDaoSupport implements ModuleDao {

	@Override
	public void addModule(Module module) {
		getHibernateTemplate().save(module);

	}

	@Override
	public List<Module> findAllModule() {
		return (List<Module>) getHibernateTemplate().find("From Module");

	}

	@Override
	public void deleteModuleById(int module_id) {
		Module module = getHibernateTemplate().get(Module.class, module_id);
		getHibernateTemplate().delete(module);
	}

	@Override
	public void updateModule(Module module) {
		getHibernateTemplate().update(module);

	}

	@Override
	public Module getModuleById(int module_id) {
		return getHibernateTemplate().get(Module.class, module_id);

	}

	@Override
	public Module getModuleBymodulename(String modulename) {
		List<Module> list = (List<Module>) getHibernateTemplate().find("From Module where modulename=?", modulename);
		if (list != null && list.size() > 0) {
			Module m = list.get(0);
			return m;
		}
		return null;
	}

	@Override
	public List<Function> getFunctionListsByModuleId(int module_id) {
		// 用ID查询出模块，根据模块再得到功能列表
		Module module = getHibernateTemplate().get(Module.class, module_id);
		List<Function> lists=MyUtils.setToList(module.getFunctionLists());
		return lists;

	}

}
