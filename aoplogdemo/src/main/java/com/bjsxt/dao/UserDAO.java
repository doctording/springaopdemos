package com.bjsxt.dao;
import com.bjsxt.model.User;

// 接口类
public interface UserDAO {
	
	void save(User user);
	
	void delete(User user);
}
