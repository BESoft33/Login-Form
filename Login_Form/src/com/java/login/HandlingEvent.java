package com.java.login;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import com.java.signup.*;

public class HandlingEvent extends HomePage implements ActionListener{ 
	public HandlingEvent() throws Exception{
		actionEvent();
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

		if(e.getSource()==login) {
			//System.out.println("Username: "+usernameField.getText());
			String pass=passwordField.toString();
			if(usernameField.getText()==null || pass==null) {
				System.out.println("Username or Password field is empty");
				return;
			}
			else {
				
			}
		}
		
		if(e.getSource()==signup) {
			Signup sign=new Signup();
		}
		
		if(e.getSource()==reset) {
			usernameField.setText("");
			passwordField.setText("");
		}
		
		if(e.getSource()==showPassword) {
						
			if(showPassword.isSelected()) {
				passwordField.setEchoChar((char)0);
			}
			else {
				passwordField.setEchoChar('*');
			}		
		}
	}
	catch(Exception exception) {
	System.out.println(exception);
	}	
}
}


	

