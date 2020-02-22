package com.java.signup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VerifyAccount extends Signup implements ActionListener{
	
	public VerifyAccount() throws Exception{
		try {
			createAccount.addActionListener(this);
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
//		try {
		if(e.getSource()==createAccount) {
			String fn,ln,un;
			char[] p1,p2;
			fn=firstname.getText();
			ln=lastname.getText();
			un=userField.getText();
			p1=pwdField1.getPassword();
			p2=pwdField2.getPassword();
			
			if(fn!=null && ln!=null && p1==p2) {
				//Add to Database
				try {
				stmt.setString(1,fn);
				stmt.setString(2,ln);
				stmt.setString(3,un);
				String pass=String.copyValueOf(p1);
				stmt.setString(4,pass);
				}
				catch(SQLException sq) {
					System.out.println(sq);
				}
			}
			else{
				//Popup Error message here
			}
		}

	}
}




