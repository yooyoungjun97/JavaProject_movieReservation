package com.java.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	private static DataSource dataSource = new DataSource();

	private DataSource() {
		driverClassName = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@10.78.101.159:1521:XE"; 
		username = "MOVINGMOVIE";
		password = "movie";
	}

	public static DataSource getInstance() {
		return dataSource;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection()throws SQLException {
		
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(url, username, password);
		
		return conn;
	}
	

}







