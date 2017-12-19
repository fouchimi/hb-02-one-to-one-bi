package com.example.jdbc;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection connection = (Connection) DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection Successful !");
		}catch(Exception ex) {
			
		}
	}

}
