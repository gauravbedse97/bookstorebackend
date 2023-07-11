package com.jdbc.examples;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class SelectDemo {

	public static void main(String[] args) { 
		try {
			Connection con=ConnectionProvider.getConnection();//custom method for driver connection
			String query="select * from table1";
			Statement stm=con.createStatement();
			ResultSet set=stm.executeQuery(query);
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String city=set.getString(3);
				System.out.println(id+" - "+name+" - "+city);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
