package com.SupportUi.forms;

import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.Retailsols.com.MyLogger;
import com.Retailsols.com.SupportUI;
import com.Retailsols.com.VerifyStoreNumber;
import com.retail.service.CountMnt;
import com.retail.service.StrBankMnt;

public class CountPannel {
	
	private static String strnbr;
	private static String countid;

	public static Panel getCountPanel()
	{
		Panel countpannel = new Panel();
		countpannel.setBackground(new Color(30, 144, 255));
		countpannel.setLayout(null);
		
		
		Label label_2 = new Label("Count Issue");
		countpannel.add(label_2);
		
		Label label_18 = new Label("Store Number");
		label_18.setBounds(188, 47, 86, 22);
		countpannel.add(label_18);
		
		JTextField textField_15 = new JTextField();
		textField_15.setBounds(280, 47, 89, 22);
		countpannel.add(textField_15);
		
		Label label_19 = new Label("Count ID");
		label_19.setBounds(200, 108, 62, 22);
		countpannel.add(label_19);
		
		JTextField textField_16 = new JTextField();
		textField_16.setBounds(280, 108, 89, 22);
		countpannel.add(textField_16);
		
		JButton btnNewButton_4 = new JButton("Process");
		btnNewButton_4.setBackground(new Color(0, 128, 0));
		btnNewButton_4.setBounds(251, 166, 89, 23);
		countpannel.add(btnNewButton_4);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				strnbr=textField_15.getText();
				countid=textField_16.getText();
				if(!VerifyStoreNumber.validteStore(strnbr))
				{
					SupportUI.statuslabel.setText("invalid store number");
					MyLogger.log(Level.INFO, "enterd invalid store number: "+strnbr+"");
				}
				else
				{
					CountMnt.genCountMnt(strnbr, countid);
					SupportUI.statuslabel.setText("mnt has been generated sucessfully");
					MyLogger.log(Level.INFO, " delete count mnt has genereted for the store: "+strnbr+"");
					
					textField_15.setText("");
					textField_16.setText("");
				}
				
			}
		});
		
		return countpannel;
	}
}
