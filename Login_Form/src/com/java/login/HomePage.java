package com.java.login;

import java.awt.event.ActionListener;

import javax.swing.*;

import com.java.database.DatabaseConnector;

public class HomePage{
	protected static DatabaseConnector connector;
	
	protected static HandlingEvent event;
	
	protected static JFrame frame;
	
	protected static JLabel username;
	protected static JLabel password;
	
	protected static JButton login;
	protected static JButton signup;
	protected static JButton reset;
	
	protected static JTextField usernameField;
	protected static JPasswordField passwordField;
	
	protected static JPanel container;
	
	protected static JCheckBox showPassword;    
    
	public void setWorkspace() throws Exception{
		frame=new JFrame();
		
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
	
		frame.add(container);
		container.setVisible(true);
	
		frame.setTitle("Simple Login Form");
	
		frame.setVisible(true);
		frame.setSize(600,500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
		
	public void defineLayout() throws Exception{
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
	public void setDatabaseConnector() throws Exception {
		connector=new DatabaseConnector();
	}
	public void handleEvents() throws Exception{
			event=new HandlingEvent();
	}
	
	public static void main (String[] args){
		HomePage homepage=new HomePage();

		try {
			homepage.setWorkspace();
			homepage.defineLayout();
			homepage.addItems();
			homepage.handleEvents();
			homepage.setDatabaseConnector();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
		
	}
}
