package com.jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	private static Connection con;
	public static Connection getConnection() {
		try {
			if(con == null) {
				//load driver
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				//create onnection
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Nishant@1999");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
