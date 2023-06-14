package com.free.company.dao.impl;

import java.sql.Connection;

import com.free.company.bean.User;
import com.free.company.dao.BaseDao;
import com.free.company.dao.UserDao;
import com.free.company.util.JDBCUtils;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUser(User user) {
		String sql = "SELECT id,username,`password`,email FROM users WHERE username = ? And `password` = ?";

		return this.getBean(sql, user.getUsername(), user.getPassword());
	}

	@Override
	public boolean checkUserName(String username) {
		String sql = "SELECT id,username,`password`,email FROM users WHERE username = ?";
		User user = this.getBean(sql, username);
		return user != null;
	}

	@Override
	public void saveUser(User user) {
		String sql = "INSERT INTO users(username,password,email) VALUES(?,?,?)";
		this.update(sql,user.getUsername(),user.getPassword(),user.getEmail());
	}

}
