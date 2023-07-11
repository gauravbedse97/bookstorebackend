package com.jdbc.examples;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImagesTable {

	public static void main(String[] args) {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//create onnection
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Nishant@1999");
			
			//query to be executed
			String query="insert into images(img)values(?)";
					
			//PreparedStatement pstmt- An object that represents a precompiled SQL statement. 
			PreparedStatement pstmt=con.prepareStatement(query);
			
			FileInputStream fis=new FileInputStream("C:/Users/HP/Desktop/shivajimaharaj.jpg");
			pstmt.setBinaryStream(1, fis,fis.available());
			//execute query
			pstmt.executeUpdate();
			System.out.println("Images Inserted Succesfully..");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
