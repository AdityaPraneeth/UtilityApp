package com.Retailsols.com;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SupportLogin extends Canvas {

	private JFrame frame;
	private JTextField nametextField;
	private JTextField  loginidtextField;
	private JPasswordField  PasstextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupportLogin window = new SupportLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupportLogin() {
		initialize();
	}
	
		/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 203, 353);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblN = new JLabel("");
		lblN.setIcon(new ImageIcon(".\\images\\loginicon.jpeg"));
		lblN.setBounds(51, 30, 112, 95);
		panel.add(lblN);
		
		JLabel lblXstoreSupportUtility = new JLabel("Xstore Support Utility Login");
		lblXstoreSupportUtility.setForeground(new Color(255, 255, 255));
		lblXstoreSupportUtility.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblXstoreSupportUtility.setBounds(10, 146, 183, 22);
		panel.add(lblXstoreSupportUtility);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSignUp.setForeground(new Color(0, 0, 255));
		lblSignUp.setBounds(289, 11, 70, 28);
		frame.getContentPane().add(lblSignUp);
		
		JLabel lblLoginId = new JLabel("Name");
		lblLoginId.setForeground(new Color(0, 0, 255));
		lblLoginId.setBounds(229, 86, 46, 14);
		frame.getContentPane().add(lblLoginId);
		
		nametextField = new JTextField();
		nametextField.setForeground(new Color(0, 0, 0));
		nametextField.setBounds(229, 99, 130, 28);
		frame.getContentPane().add(nametextField);
		nametextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Login Id");
		lblPassword.setForeground(new Color(0, 0, 255));
		lblPassword.setBounds(229, 138, 70, 14);
		frame.getContentPane().add(lblPassword);
		
		loginidtextField = new JTextField();
		loginidtextField.setColumns(10);
		loginidtextField.setBounds(229, 152, 130, 28);
		frame.getContentPane().add(loginidtextField);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setForeground(Color.BLUE);
		lblPassword_1.setBounds(229, 194, 70, 14);
		frame.getContentPane().add(lblPassword_1);
		
		PasstextField = new JPasswordField();
		PasstextField.setColumns(10);
		PasstextField.setBounds(229, 208, 130, 28);
		frame.getContentPane().add(PasstextField);
		
		JLabel lblInvalidUserName = new JLabel("*Invalid user name or password");
		lblInvalidUserName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInvalidUserName.setForeground(new Color(255, 0, 0));
		lblInvalidUserName.setBounds(229, 50, 175, 25);
		lblInvalidUserName.setVisible(false);
		frame.getContentPane().add(lblInvalidUserName);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=nametextField.getText();
				String userid=loginidtextField.getText();
				String password=PasstextField.getText();
				
				loginidtextField.setText("");
				PasstextField.setText("");
				nametextField.setText("");
				
				boolean authorizedUser=VerifyLogin.athuntecate(userid, password);
				
				if(true)
				{
					SupportUI.launch(userid, name);
					 MyLogger.log(Level.INFO, "user login: "+userid+"");
				}
				else
				{
					MyLogger.log(Level.INFO, "login attempt failed by user: "+userid+"");
					lblInvalidUserName.setVisible(true);
				}
			}
		});
		btnSignIn.setBackground(new Color(0, 128, 0));
		btnSignIn.setBounds(337, 267, 78, 28);
		frame.getContentPane().add(btnSignIn);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		btnCancel.setBackground(new Color(0, 128, 0));
		btnCancel.setBounds(213, 267, 86, 28);
		frame.getContentPane().add(btnCancel);
		
		
		frame.setUndecorated(true);

		
	}
}
