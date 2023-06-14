package com.free.company.test;

import org.junit.Test;

import com.free.company.bean.User;
import com.free.company.dao.UserDao;
import com.free.company.dao.impl.UserDaoImpl;

public class UserDaoImplTest {

	private UserDao userDao = new UserDaoImpl();
	@Test
	public void testGetUser() {
		User user = userDao.getUser(new User(null, "test01", "test01", null));

		System.out.println(user);
	}

	@Test
	public void testCheckUserName() {
		boolean yOn = userDao.checkUserName("test01d");
		System.out.println(yOn);
	}


}
