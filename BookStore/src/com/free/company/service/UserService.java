package com.free.company.service;

import com.free.company.bean.User;

public interface UserService {

	User getUser(User user);

	User login(User user);

	boolean regist(User user);

	void saveUser(User user);

	boolean checkUserName(String username);
}
