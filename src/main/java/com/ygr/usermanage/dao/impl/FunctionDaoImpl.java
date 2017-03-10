package com.ygr.usermanage.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.ygr.usermanage.dao.FunctionDao;
import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.model.Module;
import com.ygr.usermanage.utils.MyHibernateDaoSupport;

@Transactional
@Repository("functionDao")
@Scope("singleton")
public class FunctionDaoImpl extends MyHibernateDaoSupport implements FunctionDao {

	@Override
	public void addFunction(Function function) {
		getHibernateTemplate().save(function);

	}

	@Override
	public List<Function> findAllFunction() {
		return (List<Function>) getHibernateTemplate().find("From Function");

	}

	@Override
	public void deleteFunctionById(int function_id) {
		Function function = getHibernateTemplate().get(Function.class, function_id);
		getHibernateTemplate().delete(function);

	}

	@Override
	public void updateFunction(Function function) {
		getHibernateTemplate().update(function);

	}

	@Override
	public Function findFunctionById(int function_id) {
		return getHibernateTemplate().get(Function.class, function_id);

	}

}
