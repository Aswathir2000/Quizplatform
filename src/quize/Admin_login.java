package quize;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
public class Admin_login extends JFrame implements ActionListener{
	JLabel lab;
	JLabel username;
	JLabel password;
	JButton fp;
	JButton exit;
	JButton submit;
	JTextField userfield;
	JTextField passfield;
	public Admin_login(){
		setTitle("welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		lab = new JLabel("Admin LOG-IN Page");
		fp = new JButton("Forget Password ?");
		exit = new JButton("EXIT");
		username = new JLabel("USERNAME");
		password = new JLabel("PASSWORD");
		submit = new JButton("SUBMIT");
		userfield = new JTextField();
		passfield = new JTextField();
		fp.setBounds(50,280,150,30);
		fp.setBackground(Color.white);
		fp.setForeground(Color.BLUE);
		exit.setBounds(290,200,100,40);
		exit.setBackground(Color.black);
		exit.setForeground(Color.white);
		lab.setBounds(250,0,100,50);
		lab.setForeground(Color.red);
		username.setBounds(150,100,80,30);
		password.setBounds(150,150,100,30);
		submit.setBounds(160,200,100,40);
		userfield.setBounds(300,100,80,30);
		passfield.setBounds(300,150,80,30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		fp.addActionListener(this);
		exit.addActionListener(this);
		add(username);
		add(exit);
		add(password);
		add(submit);
		add(userfield);
		add(passfield);
		add(lab);
		add(fp);
		setLayout(null);
		setSize(600,400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent a){
		if(a.getSource() == submit) {
			try {
				new four();
				
				String url = "jdbc:mysql:///bankmanagementsystem/authentication";
				String username = "root";
				String password = "aswathi";
				Connection connection;
				connection = DriverManager.getConnection(url, username, password);
				String username1 = userfield.getText();
				String password1 = passfield.getText();
				String sql = "SELECT * FROM authen WHERE username = ? AND password = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, username1);
				statement.setString(2, password1);
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {
					
					JOptionPane.showMessageDialog(Admin_login.this,
			                "Login Successful",
			                " ",
			                JOptionPane.INFORMATION_MESSAGE);
					
					this.dispose();
					
				} else {
				    // Invalid credentials
				    System.out.println("Authentication failed!");
				}
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}if(a.getSource() == fp){
			new  forgetpass();
			this.dispose();
			
		}if(a.getSource() == exit){
			this.dispose();
		}
	}
}