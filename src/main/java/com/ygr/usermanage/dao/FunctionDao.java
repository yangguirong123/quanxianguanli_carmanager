package com.ygr.usermanage.dao;

import java.util.List;

import com.ygr.usermanage.model.Function;

public interface FunctionDao {
	void addFunction(Function function);
	
	List<Function> findAllFunction();
	
	void deleteFunctionById( int function_id);
	
	void updateFunction( Function function);
}
