package com.jdbc.examples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class FunctionCallDemo {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Nishant@1999");
			CallableStatement stmt=con.prepareCall("{?= call hello_world}");
			//hello_world is the stored function in jdbc database that returns Hello World

			ResultSet set=stmt.executeQuery();
			while(set.next()) {
				String string=set.getString(1);
				System.out.println(string);
			}
			System.out.println("Function Executed Succcesfully...");
			con.close();
		    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
