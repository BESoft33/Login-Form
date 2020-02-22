package com.java.login;

import javax.swing.*;

import com.java.database.DatabaseConnector;

public class HomePage extends JFrame{
	
	protected  JLabel username;
	protected  JLabel password;
	protected  JButton login;
	protected  JButton signup;
	protected  JButton reset;
	protected  JTextField usernameField;
	protected  JPasswordField passwordField;
	protected  JPanel container;
	protected  JCheckBox showPassword;
	protected DatabaseConnector connector;

	public HomePage() throws Exception{
		try {	
			connector=new DatabaseConnector();
		
			container= new JPanel();
			container.setLayout(null);
		
			username=new JLabel("Username: ");
			password=new JLabel("Password: ");
		
			usernameField=new JTextField();
			passwordField=new JPasswordField();
		
			login=new JButton("Login");
			signup=new JButton("Signup");
			reset=new JButton("Reset");
		
			showPassword=new JCheckBox("Show Password");
		
			defineLayout();
			addItems();
		
			add(container);
			container.setVisible(true);
		
			setTitle("Simple Login Form");
		
			setVisible(true);
			setSize(600,500);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		}
	
		catch(Exception e) {
			System.out.println(e);
		}
	
	}
	
		
	public void defineLayout() {
		username.setBounds(100,100,150,50);
		password.setBounds(100,170,150,50);
		usernameField.setBounds(300,100,200,40);
		passwordField.setBounds(300,170,200,40);
		login.setBounds(150,250,100,30);
		signup.setBounds(450,250,100,30);
		reset.setBounds(300,250,100,30);
		showPassword.setBounds(300,210,300,30);
		
	}
	
	public void addItems() {
		container.add(username);
		container.add(usernameField);
		container.add(password);
		container.add(passwordField);
		container.add(login);
		container.add(signup);
		container.add(reset);
		container.add(showPassword);
		
	}	
}
