package com.free.company.dao;

import com.free.company.bean.User;

public interface UserDao {

	User getUser(User user);

	boolean checkUserName(String username);

	void saveUser(User user);

}
