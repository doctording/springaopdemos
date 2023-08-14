package com.bjsxt.dao.impl;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;
import org.springframework.stereotype.Component;

@Component("u") 
public class UserDAOImpl implements UserDAO {

	@Override
	public void save(User user) {
		//Hibernate
		//JDBC
		//XML
		//NetWork
		System.out.println("user saved!");
		//throw new RuntimeException("exeption!");
	}

}
