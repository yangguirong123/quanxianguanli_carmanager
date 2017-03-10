package com.ygr.usermanage.serverimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ygr.usermanage.dao.FunctionDao;
import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.server.FunctionServer;

@Service("functionServer")
@Scope("singleton")
public class FunctionServerImpl implements FunctionServer {
	@Autowired
	private FunctionDao functionDao;

	@Override
	public boolean addFunction(Function function) {
		if (null == functionDao.findFunctionById(function.getFunction_id())) {
			functionDao.addFunction(function);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Function> findAllFunction() {
		return functionDao.findAllFunction();
	}

	@Override
	public void deleteFunctionById(int function_id) {
		functionDao.deleteFunctionById(function_id);
	}

	@Override
	public void updateFunction(Function function) {
		functionDao.updateFunction(function);

	}

	@Override
	public Function findFunctionById(int function_id) {
		return functionDao.findFunctionById(function_id);
	}

}
