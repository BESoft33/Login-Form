package com.java.login;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.java.database.DatabaseConnector;
import com.java.signup.Signup;
import com.java.signup.VerifyAccount;

import java.awt.event.ActionEvent;

public class HandlingEvent implements ActionListener{ 
	
	public HandlingEvent() {
		actionEvent();
	}
	
	public void actionEvent() {
		HomePage.login.addActionListener(this);
		HomePage.signup.addActionListener(this);
		HomePage.reset.addActionListener(this);
		HomePage.showPassword.addActionListener(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
	try {
		String username,password;
		username=HomePage.usernameField.getText();
		password=HomePage.passwordField.getText();
		
		if(e.getSource()==HomePage.login) {
			
			if(username.isBlank()|| password.isBlank()) {
				JOptionPane.showMessageDialog(null, "Username or Password Field cannot be empty");
				return;
			}
			
			String query="Select * from LoginData where username=? and password=?";
			ResultSet rs=DatabaseConnector.stmt.executeQuery(query);
			if(!rs.next()) {
				JOptionPane.showMessageDialog(null, "Username and password mismatch or doesn't exist");
			}
			else {
				//Login Successful
			}
			
		}
		
		else if(e.getSource()==HomePage.signup) {
			
			Signup signup=new Signup();
			VerifyAccount verify=new VerifyAccount();
			
			signup.setComponentSize();
			signup.addComponents();
		}
		
		else if(e.getSource()==HomePage.reset) {
			HomePage.usernameField.setText("");
			HomePage.passwordField.setText("");
		}
		
		else if(e.getSource()==HomePage.showPassword) {
						
			if(HomePage.showPassword.isSelected()) {
				HomePage.passwordField.setEchoChar((char)0);
			}
			else {
				HomePage.passwordField.setEchoChar('*');
			}		
		}
	}
	catch(Exception exception) {
		System.out.print(exception);
	}	
}
}


	

