package com.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DatabaseConnector{
	
	public Connection getConnection() throws Exception{	
		Class.forName("com.mysql.jdbc.Driver");	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3300/ProjectUserData","root","");
		return conn;			
		//System.out.println("Successfully connected to database");		
	}
	
}
