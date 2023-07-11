package com.jdbc.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class UserInputInsertion {

	public static void main(String[] args) {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//create onnection
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Nishant@1999");
			
			//query to be executed
			String query="insert into table1(tName,tCity)values(?,?)";
					
			
			PreparedStatement pstmt=con.prepareStatement(query);
			//we can execute the same using scanner Class also
			BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Name: ");
			String name=bReader.readLine();
			System.out.print("Enter City: ");
			String city=bReader.readLine();
			pstmt.setString(1,name);
			pstmt.setString(2,city);
			//execute query
			pstmt.executeUpdate();
			System.out.println("Values Inserted Succesfully..");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
