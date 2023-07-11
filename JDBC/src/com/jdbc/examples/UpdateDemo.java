package com.jdbc.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class UpdateDemo {
	public static void main(String[] args) {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//create onnection
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Nishant@1999");
			
			//query to be executed
			String query="update table1 set tName=?,tCity=? Where tid=?";
					
			
			BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Name: ");
			String name=bReader.readLine();
			
			System.out.print("Enter City: ");
			String city=bReader.readLine();
			
			System.out.print("Enetr th student id: ");
			int id=Integer.parseInt(bReader.readLine());// to convert string to int as readLine method returns string value
			
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1,name);
			pstmt.setString(2,city);
			pstmt.setInt(3, id);
			//execute query
			pstmt.executeUpdate();
			System.out.println("Values Updated Succesfully..");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
