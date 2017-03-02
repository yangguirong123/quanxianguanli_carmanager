package com.ygr.usermanage.daoimpl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ygr.usermanage.dao.FunctionDao;
import com.ygr.usermanage.dao.ModuleDao;
import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.model.Module;

public class DaoImplTest {
	
	private ModuleDao moduleDao;
	private FunctionDao functionDao;
	
	@Before
	public void before(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		// moduleDao=(ModuleDao) ac.getBean("moduleDao");
		functionDao=(FunctionDao)ac.getBean("functionDao");
		
	}
	@Test
	public void testAddModule() {
		Module module=new Module("用户管理","用户管理模块");
		moduleDao.addModule(module);
	}

	@Test
	public void testFindAllModule() {
		List<Module> list=moduleDao.findAllModule();
		for( Module m:list){
			System.out.println("模块："+m);
		}
	}
	@Test
	public void addFunctionTset(){
		Function function=new Function("deletstudent.do","删除学生功能");
		functionDao.addFunction(function);
		
	}
	@Test
	public void findAllFunctionTset(){
		
		List<Function> list=functionDao.findAllFunction();
		for(Function f:list){
			System.out.println("function:"+f);
		}
		
	}

}
