package com.jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {

	public static void main(String[] args) {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//create connection
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Nishant@1999");
			//The basic service for managing a set of JDBC drivers. 
			if(con.isClosed()) {
				System.out.println("connection is closed");
			}else {
				System.out.println("connection created...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
