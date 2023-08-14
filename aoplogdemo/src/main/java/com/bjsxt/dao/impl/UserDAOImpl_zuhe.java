package com.bjsxt.dao.impl;

import com.aop.LogInterceptor;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

public class UserDAOImpl_zuhe implements UserDAO {

	public UserDAO userDao = new UserDAOImplMySQL();

	LogInterceptor logInterceptor = new LogInterceptor();

	@Override
	public void save(User user) {
		logInterceptor.beforeMethod();
		userDao.save(user);
	}

	@Override
	public void delete(User user) {
		logInterceptor.beforeMethod();
		userDao.delete(user);
	}

}
