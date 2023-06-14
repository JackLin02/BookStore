package com.free.company.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils {

	private static DataSource dataSource;

	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

	static {
		try {
			Properties pro = new Properties();
			pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

			dataSource = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		Connection connection = threadLocal.get();
		try {
			if(connection == null){
				connection = dataSource.getConnection();
				threadLocal.set(connection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void releaseConnection(){
		Connection connection = threadLocal.get();
		if(connection != null){
			try {
				connection.close();
				threadLocal.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
