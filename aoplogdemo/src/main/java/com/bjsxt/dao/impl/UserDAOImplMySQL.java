package com.bjsxt.dao.impl;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

//
public class UserDAOImplMySQL implements UserDAO {

	@Override
	public void save(User user) {
		//Hibernate
		//JDBC
		//XML
		//NetWork
		System.out.println("..........use MySQL: user saved!");
	}

	@Override
	public void delete(User user) {
		System.out.println("..........use MySQL: user deleted!");
	}

}
