package com.free.company.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.free.company.util.JDBCUtils;

public class BaseDao<T> {
	private QueryRunner queryRunner = new QueryRunner();
	private Class<T> type;

	public BaseDao() {
		Class clazz = this.getClass();
		ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
		Type[] types = parameterizedType.getActualTypeArguments();
		this.type = (Class<T>) types[0];
	}

	public int update(String sql, Object... params) {
		Connection connection = JDBCUtils.getConnection();
		int count = 0;
		try {
			count = queryRunner.update(connection, sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		}
		return count;
	}

	public void batchUpdate(String sql, Object[][] params) {
		Connection connection = JDBCUtils.getConnection();
		try {
			queryRunner.batch(connection, sql, params);
		} catch (SQLException e) {

			throw new RuntimeException(e);
		} finally {
		}
	}

	public T getBean(String sql, Object... params) {
		Connection connection = JDBCUtils.getConnection();
		T t = null;
		try {
			t = queryRunner.query(connection, sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		}
		return t;
	}

	public List<T> getBeanList(String sql, Object... params) {
		Connection connection = JDBCUtils.getConnection();
		List<T> list = null;
		try {
			list = queryRunner.query(connection, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		}
		return list;
	}

	public Object getSingleValue(String sql, Object... params) {
		Connection connection = JDBCUtils.getConnection();
		Object o = null;
		try {
			o = queryRunner.query(connection, sql, new ScalarHandler<>(), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		}
		return o;
	}
}
