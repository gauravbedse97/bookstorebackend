package com.jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//create onnection
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Nishant@1999");

			//query to be executed
			String query="insert into table1(tName,tCity)values(?,?)";


			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1,"Nishant");
			pstmt.setString(2,"Wadgaon");
			//it insert the values in one row at a time which is provided at last as given below
			pstmt.setString(1,"Pranav");
			pstmt.setString(2,"Shirsoli");
			//execute query
			pstmt.executeUpdate();
			System.out.println("Values Inserted Succesfully..");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
