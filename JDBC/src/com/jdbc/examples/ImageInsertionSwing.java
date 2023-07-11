package com.jdbc.examples;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ImageInsertionSwing {
	public static void main(String[] args) {
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//create onnection
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Nishant@1999");
			
			//query to be executed
			String query="insert into images(img)values(?)";
					
			
			PreparedStatement pstmt=con.prepareStatement(query);
			JFileChooser jfc=new JFileChooser();
			jfc.showOpenDialog(jfc);
			File file=jfc.getSelectedFile();
			
			FileInputStream fis=new FileInputStream(file);
			pstmt.setBinaryStream(1, fis,fis.available());
			//execute query
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Images Inserted Succesfully..");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
