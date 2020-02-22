package com.java.signup;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.java.database.DatabaseConnector;

public class Signup extends DatabaseConnector{
	protected JFrame frame;
	protected JPanel collector;
	protected JLabel fname,lname,username,createPassword,verifyPassword;
	protected JTextField firstname,lastname,userField;
	protected JPasswordField pwdField1,pwdField2;
	protected JButton createAccount;
	
	public Signup() throws Exception{
		try {
			frame=new JFrame();
			
			collector=new JPanel();
			collector.setLayout(null);
			collector.setBackground(new Color(100,100,100,40));
		
			fname=new JLabel("First Name: ");
			lname=new JLabel("Last Name: ");
			username=new JLabel("Set Username: ");
			createPassword=new JLabel("Create Password: ");
			verifyPassword=new JLabel("Verify Password: ");
		
			firstname=new JTextField();
			lastname=new JTextField();
			userField=new JTextField();
		
			pwdField1=new JPasswordField();
			pwdField2=new JPasswordField();
		
			createAccount=new JButton("Create Account");
		
			frame.add(collector);
			frame.setTitle("Signup");
			frame.setSize(600,500);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			setComponentSize();
			addComponents();
		}
		
		catch(Exception e) {
			System.out.print(e);
		}
		
	}
	
	public void addComponents() {
		collector.add(fname);
		collector.add(lname);
		collector.add(username);
		collector.add(createPassword);
		collector.add(verifyPassword);
		
		collector.add(firstname);
		collector.add(lastname);
		collector.add(userField);
		
		collector.add(pwdField1);
		collector.add(pwdField2);
		
		collector.add(createAccount);
	}
	
	public void setComponentSize() {
		fname.setBounds(10,10,150,30);
		lname.setBounds(10,50,150,30);
		username.setBounds(10,90,150,30);
		createPassword.setBounds(10,130,150,30);
		verifyPassword.setBounds(10,170,150,30);
		
		firstname.setBounds(200,10,150,30);
		lastname.setBounds(200,50,150,30);
		userField.setBounds(200,90,150,30);
		
		pwdField1.setBounds(200,130,150,30);
		pwdField2.setBounds(200,170,150,30);
		
		createAccount.setBounds(120,220,200,25);
		
	}
	public static void main(String[] args) throws Exception {
		Signup signup=new Signup();
	}
}
