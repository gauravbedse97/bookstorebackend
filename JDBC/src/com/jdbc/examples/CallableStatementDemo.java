package com.jdbc.examples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;



public class CallableStatementDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Nishant@1999");
			CallableStatement stmt=con.prepareCall("{call insertRecords(?,?,?)}");
			//insertRecords is the stored procedure in jdbc database
			stmt.setInt(1, 6);
			stmt.setString(2, "Navin");
			stmt.setString(3, "NY");
			stmt.execute();
			System.out.println("Record Inserted Succcesfully...");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
