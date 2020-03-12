package com.java.login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.java.database.DatabaseConnector;

public class Signup implements ActionListener {
	private  JFrame frame;
	private  JPanel collector;
	private  JLabel fname, lname;
	private  JLabel username;
	private  JLabel createPassword;
	public  JTextField firstname, lastname, userField;
	public  JPasswordField pwdField1;
	public  JButton createAccount;
	private DatabaseConnector database;

	public Signup(){
		
			frame = new JFrame();

			collector = new JPanel();
			collector.setLayout(null);
			collector.setBackground(new Color(100, 100, 100, 40));

			fname = new JLabel("First Name: ");
			lname = new JLabel("Last Name: ");
			username = new JLabel("Set Username: ");
			createPassword = new JLabel("Create Password: ");

			firstname = new JTextField();
			lastname = new JTextField();
			userField = new JTextField();

			pwdField1 = new JPasswordField();

			createAccount = new JButton("Create Account");

			frame.add(collector);
			frame.setTitle("Signup");
			frame.setSize(600, 500);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			createAccount.addActionListener(this);
			
			database=new DatabaseConnector();
		}

	public void addComponents() {

		collector.add(fname);
		collector.add(lname);
		collector.add(username);
		collector.add(createPassword);

		collector.add(firstname);
		collector.add(lastname);
		collector.add(userField);

		collector.add(pwdField1);

		collector.add(createAccount);
	}

	public void setComponentSize() {

		fname.setBounds(10, 10, 150, 30);
		lname.setBounds(10, 50, 150, 30);
		username.setBounds(10, 90, 150, 30);
		createPassword.setBounds(10, 130, 150, 30);

		firstname.setBounds(200, 10, 150, 30);
		lastname.setBounds(200, 50, 150, 30);
		userField.setBounds(200, 90, 150, 30);

		pwdField1.setBounds(200, 130, 150, 30);

		createAccount.setBounds(120, 200, 200, 25);

	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub

		if(e.getSource()==createAccount) {
			Connection conn = null;
			try {
				conn = database.getConnection();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String fn,ln,un,p1;
			
			fn=firstname.getText();
			ln=lastname.getText();
			un=userField.getText();
			p1=pwdField1.getText();
		
			
			if(!fn.isBlank()&& !ln.isBlank()&& !un.isBlank() && !p1.isBlank()){
				//All user-input fields should be non-empty
				
				try {
					String sql="Insert into LoginData"+
							"(firstname,lastname,username,password)"+
							"values(?,?,?,?)";
					
					PreparedStatement stmt=conn.prepareStatement(sql);
					
					stmt.setString(1,fn);
					stmt.setString(2,ln);
					stmt.setString(3,un);						
					stmt.setString(4,p1);
				
					stmt.execute();
						
					JOptionPane.showMessageDialog(null, "Account successfully added to database");
					
					new HomePage().frame.setVisible(true);;
					frame.dispose();
					
				}catch(SQLException sq) {System.out.println(sq);}
				
			}
			else {
				JOptionPane.showMessageDialog(null,"Fill all the fields to proceed");
			}
		}

	}
	
	public static void main(String[] args) {
		Signup signup=new Signup();
		try {
			signup.addComponents();
			signup.setComponentSize();
		}catch(Exception e) {}
		
	}
}
