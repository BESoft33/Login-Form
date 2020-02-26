package com.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DatabaseConnector{
	public static Connection conn;
	public String connector;
	public String sql;
	public static PreparedStatement stmt;
	public ResultSet rs;
	
	public DatabaseConnector() throws Exception{
			Class.forName("com.mysql.jdbc.Driver");
			connector="jdbc:mysql://localhost:3300/ProjectUserData";
			//ProjectUserData is DATABASE name
			
			conn=DriverManager.getConnection(connector,"root","");
			sql="Insert into LoginData"+
					"(firstname,lastname,username,password)"+
					"values(?,?,?,?)";			
			//LoginData is TABLE name
			
			stmt=conn.prepareStatement(sql);
			
			System.out.println("Successfully connected to database");
			
	}
}
