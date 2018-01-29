package com.test.connutil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class EmpConnection {

	private static Connection connection;
	
	public Connection getConnection() {
		
		try {
			
			Properties p = new Properties();
			
			InputStream i =getClass().getClassLoader().getResourceAsStream("db.properties");
			p.load(i);
			
			String driver = p.getProperty("db.driver");
			String url = p.getProperty("db.url");
			String user = p.getProperty("db.user");
			String password = p.getProperty("db.password");
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			
			System.out.println(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return connection;
	
	}
	
}
