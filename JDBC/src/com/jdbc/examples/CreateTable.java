package com.jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//create onnection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Nishant@1999");
			//DriverManger - The basic service for managing a set of JDBC drivers. 
			//query to be executed
			String query="create table table1(tid int(20) primary key auto_increment,tName varchar(200),tCity varchar(400))";
			
			Statement stmt=con.createStatement();
			//execute query
			stmt.executeUpdate(query);
			System.out.println("Table created Succesfully..");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
