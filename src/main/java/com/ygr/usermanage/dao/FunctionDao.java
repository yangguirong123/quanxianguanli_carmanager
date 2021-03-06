package com.ygr.usermanage.dao;

import java.util.List;

import com.ygr.usermanage.model.Function;

public interface FunctionDao {
	/**
	 * 添加一个功能
	 */
	void addFunction(Function function);
	/**
	 * 查询所有的功能
	 */
	List<Function> findAllFunction();
	/**
	 * 通过id删除功能
	 */
	void deleteFunctionById( int function_id);
	/**
	 * 更新修改功能信息
	 */
	void updateFunction( Function function);
	/**
	 * 根据功能id查询功能信息
	 */
	Function findFunctionById(int function_id);
	/**
	 * 根据功能名称查询功能信息
	 */
	Function findFunctionByfunctionName(String code);
	
}
