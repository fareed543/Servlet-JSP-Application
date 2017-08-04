package com.emp;

import java.sql.Connection;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class ApplicationDataSource {
	static BasicDataSource data = null;
	
	static{
		data = new BasicDataSource();
		data.setUsername("root");
		data.setPassword("");
		data.setUrl("jdbc:mysql://localhost/emp");
		data.setDriverClassName("com.mysql.jdbc.Driver");
	}
	
	public static Connection getConnection() throws Exception{
		return data.getConnection();
	}

}
