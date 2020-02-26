package com.java.signup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.java.database.DatabaseConnector;


public class VerifyAccount implements ActionListener{
	
	public VerifyAccount() throws Exception{
		try {
			Signup.createAccount.addActionListener(this);
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub

		if(e.getSource()==Signup.createAccount) {
			String fn,ln,un,p1,p2;
			
			fn=Signup.firstname.getText();
			ln=Signup.lastname.getText();
			un=Signup.userField.getText();
			p1=Signup.pwdField1.getPassword().toString();
			p2=Signup.pwdField2.getPassword().toString();
			
			System.out.println(Signup.firstname.getText());
			System.out.println(Signup.lastname.getText());
			System.out.println(Signup.userField.getText());
			System.out.println(Signup.pwdField1.getText());
			System.out.println(Signup.pwdField2.getText());
				
			try {
						
				DatabaseConnector.stmt.setString(1,fn);
				DatabaseConnector.stmt.setString(2,ln);
				DatabaseConnector.stmt.setString(3,un);						
				DatabaseConnector.stmt.setString(4,p1);
				
				DatabaseConnector.stmt.execute();
						
			}
			catch(SQLException sq) {
				System.out.println(sq);
			}
		}

	}
}




