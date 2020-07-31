package com.SupportUi.forms;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.Retailsols.com.MyLogger;
import com.Retailsols.com.SupportUI;
import com.Retailsols.com.VerifyStoreNumber;
import com.SupportUi.validations.TillValidattions;
import com.retail.service.TillMnt;


public class TillPannel {

	static JComboBox<Object> comboBox_1;
	static String[] str = { "select", "UNCOUNTED", "BEGINCOUNT", "ENDCOUNT" };
	public static String till_number;
	public static String reg_number;
	public static String store_number;
	public static String status;
	
	public static Panel getTillPannel()
	{
		Panel tillpanel = new Panel();
		tillpanel.setBackground(new Color(30, 144, 255));
		tillpanel.setLayout(null);
		
		JLabel lblStoreNumber = new JLabel("Store Number");
		lblStoreNumber.setForeground(Color.WHITE);
		lblStoreNumber.setBackground(Color.CYAN);
		lblStoreNumber.setBounds(205, 90, 86, 20);
		tillpanel.add(lblStoreNumber);
		//store number
		JTextField Textfield_storenumber = new JTextField();
		 Textfield_storenumber.setBounds(320, 90, 86, 20);
		tillpanel.add(Textfield_storenumber);
		Textfield_storenumber.setColumns(10);
		
		
		JLabel lblTillNo = new JLabel("Till Number");
		lblTillNo.setForeground(Color.WHITE);
		lblTillNo.setBackground(Color.MAGENTA);
		lblTillNo.setBounds(205, 125, 67, 14);
		tillpanel.add(lblTillNo);
		//till number
		JTextField Textfield_tillnumber = new JTextField();
		Textfield_tillnumber.setBounds(320, 121, 86, 20);
		tillpanel.add(Textfield_tillnumber);
		Textfield_tillnumber.setColumns(10);
		
	
		JLabel lblNewLabel = new JLabel("Register Number");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setBounds(205, 156, 105, 20);
		tillpanel.add(lblNewLabel);
		// register field
		JTextField textField_register = new JTextField();
		textField_register.setBounds(320, 153, 86, 20);
		tillpanel.add(textField_register);
		textField_register.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Till Status");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.MAGENTA);
		lblNewLabel_1.setBounds(205, 187, 77, 14);
		tillpanel.add(lblNewLabel_1);
		// status combobox
		comboBox_1 = new JComboBox<Object>(str);
		comboBox_1.setBounds(320, 184, 86, 20);
		tillpanel.add(comboBox_1);
		// till button process
		JButton btnProcess = new JButton("Process");
		btnProcess.setBackground(new Color(0, 128, 0));
		btnProcess.setBounds(247, 229, 89, 23);
		tillpanel.add(btnProcess);
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 store_number = Textfield_storenumber.getText();
			     reg_number =textField_register.getText();
				 till_number= Textfield_tillnumber.getText();
			     status = (String) comboBox_1.getSelectedItem();
			     
			     //validation for entering the store values
			    if(VerifyStoreNumber.validteStore(store_number))
			    {
			    	if(!TillValidattions.validateTillNo(till_number))
			    	{
			    		SupportUI.statuslabel.setText("invalid till number");
			    		MyLogger.log(Level.INFO, "enterd invalid till number: "+till_number+"");
			    	}
			    	else if(!TillValidattions.validateRegNo(reg_number))
			    	{
			    		SupportUI.statuslabel.setText("invalid register number");
			    		MyLogger.log(Level.INFO, "enterd invalid register number: "+reg_number+"");
			    	}
			    	else if(status.isEmpty())
			    	{
			    		SupportUI.statuslabel.setText("invalid  Till status");
			    		MyLogger.log(Level.INFO, "enterd invalid till status: "+status+"");
			    	}
			    	else
			    	{
			    		TillMnt.genTillMnt(store_number, till_number, status, reg_number);
			    		SupportUI.statuslabel.setText("mnt has been generated sucessfully");
			    		MyLogger.log(Level.INFO, "reset till mnt has genereted for the store: "+store_number+"\n"
			    				+ "Till no: "+till_number+"\n"
			    						+ "Till status: "+status+"\n"
			    								+ "workstation: "+reg_number);
			    		
			    		Textfield_tillnumber.setText("");
			    		textField_register.setText("");
			    		Textfield_storenumber.setText("");
			    		
			    	}
			    		
			    }
			    else
			    {
			    	SupportUI.statuslabel.setText("invalid store number");
			    	MyLogger.log(Level.INFO, "enterd invalid store number: "+store_number+"");
			    }
				
			}			
		});
		return tillpanel;
	}
}
