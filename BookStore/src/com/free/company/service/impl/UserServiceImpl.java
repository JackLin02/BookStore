package com.free.company.service.impl;

import com.free.company.bean.User;
import com.free.company.dao.UserDao;
import com.free.company.dao.impl.UserDaoImpl;
import com.free.company.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public User getUser(User user) {
		return userDao.getUser(user);
	}

	@Override
	public User login(User user) {
		return null;
	}

	@Override
	public boolean regist(User user) {
		return false;
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public boolean checkUserName(String username) {
		return userDao.checkUserName(username);
	}

}
