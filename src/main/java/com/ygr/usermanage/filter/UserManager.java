package com.ygr.usermanage.filter;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ygr.usermanage.dao.UserDao;
import com.ygr.usermanage.model.Function;
import com.ygr.usermanage.model.Role;
import com.ygr.usermanage.model.User;
import com.ygr.usermanage.utils.WebApplication;
@Component
@Scope("singleton")
public class UserManager  {
	@Autowired
	private UserDao userDao;
	
	//private static UserDao userDao;
	
//	private static UserManager UMG = null;
//	public static UserManager getInstance(){
//		if(UMG==null){
//			UMG = new UserManager();
//			initUserManager();
//		}
//		return UMG;
//	}
	
	public  boolean getGroupPermission(String userId, String action) {
		boolean results = false;
		User user = (User) userDao.findUserById(Integer.parseInt(userId));
		Role role = user.getRole();
		
		Set<Function> functionLists = role.getFunctionList();
		for(Function fuction : functionLists){
			System.out.println("code :"+fuction.getCode());
			if(fuction.getCode().equals(action)){
				results = true;
				break;
			}
		}

		return results;
	}
	public static void initUserManager(){
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
//		userDao = (UserDao) ctx.getBean("userDao");
		
//		userDao = (UserDao) WebApplication.getBean("userDao");
//		userDao = WebApplication.getBean(UserDao.class);
	}

}
