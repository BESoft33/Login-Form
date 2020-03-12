package com.java.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.java.database.DatabaseConnector;

public class HomePage implements ActionListener{
	protected  DatabaseConnector connector;
		
	protected  JFrame frame;
	
	protected  JLabel username;
	protected  JLabel password;
	
	protected  JButton login;
	protected  JButton signup;
	protected  JButton reset;
	
	protected  JTextField usernameField;
	protected  JPasswordField passwordField;
	
	protected  JPanel container;
	
	protected  JCheckBox showPassword;    
    
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
		
		connector=new DatabaseConnector();
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
	
	
	public void addItems() throws Exception{
		container.add(username);
		container.add(usernameField);
		container.add(password);
		container.add(passwordField);
		container.add(login);
		container.add(signup);
		container.add(reset);
		container.add(showPassword);
		
	}
	public void actionEvent() {
		login.addActionListener(this);
		signup.addActionListener(this);
		reset.addActionListener(this);
		showPassword.addActionListener(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
	try {
		String username,password;
		username=usernameField.getText();
		password=passwordField.getText();
		
		if(e.getSource()==login) {
			Connection conn = connector.getConnection();
			System.out.println("Connected!");

			if(username.isBlank()|| password.isBlank()) {
				JOptionPane.showMessageDialog(null, "Username or Password Field cannot be empty");
				return;
			}
			else {
				String sql="Select * from LoginData";
				PreparedStatement stmt=conn.prepareStatement(sql);
				ResultSet rs=stmt.executeQuery(sql);
				
				while(rs.next()) {
					if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
						JOptionPane.showMessageDialog(null, "Ready for login");
					}
				}
			}
		}
		
		else if(e.getSource()==signup) {
			
			Signup signup=new Signup();
			signup.addComponents();
			signup.setComponentSize();
			frame.dispose();
		}
		
		else if(e.getSource()==reset) {
			usernameField.setText("");
			passwordField.setText("");
		}
		
		else if(e.getSource()==showPassword) {
						
			if(showPassword.isSelected()) {
				passwordField.setEchoChar((char)0);
			}
			else {
				passwordField.setEchoChar('*');
			}		
		}
	}
	catch(Exception exception) {
		System.out.print(exception);
	}
	}
	
	public static void main(String[] args) {
		HomePage homepage=new HomePage();
		try {
			homepage.setWorkspace();
			homepage.defineLayout();
			homepage.addItems();
			homepage.actionEvent();
		}catch(Exception e) {
			
		}
	}
}
