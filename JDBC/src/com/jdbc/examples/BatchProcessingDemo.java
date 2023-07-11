package com.jdbc.examples;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class BatchProcessingDemo {
	public static void main(String[] args) {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//create onnection
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Nishant@1999");

			Statement stmt=con.createStatement();
			stmt.addBatch("insert into table1(tName,tCity)values('Aman','Pune')");
			stmt.addBatch("insert into table1(tName,tCity)values('Naman','Mumbai')");
			stmt.executeBatch();
			System.out.println("Values Inserted Succesfully..");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
