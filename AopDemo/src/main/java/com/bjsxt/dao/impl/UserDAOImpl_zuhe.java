package com.bjsxt.dao.impl;

import com.aop.LogInterceptor;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

public class UserDAOImpl_zuhe implements UserDAO {

	public UserDAO userDao = new UserDAOImplMySQL();

	@Override
	public void save(User user) {
		new LogInterceptor().beforeMethod();
		userDao.save(user);
	}

	@Override
	public void delete(User user) {

	}

}
