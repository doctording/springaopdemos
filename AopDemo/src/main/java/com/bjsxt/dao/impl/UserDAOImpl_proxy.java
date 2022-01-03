package com.bjsxt.dao.impl;

import com.aop.LogInterceptor;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

//
public class UserDAOImpl_proxy implements UserDAO {

	public UserDAO userDao = new UserDAOImplMySQL();
	
	public void save(User user) {
		//System.out.println("save start...");
		
		new LogInterceptor().beforeMethod();
		
		userDao.save(user);
		//System.out.println("use Sql Server: user saved!");
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

}
