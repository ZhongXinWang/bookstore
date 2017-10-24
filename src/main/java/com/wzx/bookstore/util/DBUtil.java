package com.wzx.bookstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {

	private final static String URL="jdbc:mysql://119.29.174.85:3306/bookstore";
	private final static String USER="book";
	private final static String PASS="123456";
	private final static String DRIVER="com.mysql.jdbc.Driver";
	private Connection conn;
	public void connection(){
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println(conn.toString());
			
		} catch (ClassNotFoundException e) {
	
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}

