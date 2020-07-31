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
import com.retail.service.StrBankMnt;

public class StrBankPannel {

	private static String strnbr;
	
	public static Panel getStrBankPanel()
	{
	
		Panel storebankpannel = new Panel();
		storebankpannel.setBackground(new Color(30, 144, 255));
		storebankpannel.setLayout(null);
		
		
		Label label_6 = new Label("Store Number");
		label_6.setBounds(190, 38, 81, 22);
		storebankpannel.add(label_6);
		
		JTextField textField_10 = new JTextField();
		textField_10.setBounds(277, 38, 89, 22);
		storebankpannel.add(textField_10);
		
		JButton btnNewButton_2 = new JButton("Process");
		btnNewButton_2.setBackground(new Color(0, 128, 0));
		btnNewButton_2.setBounds(242, 109, 89, 23);
		storebankpannel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				strnbr=textField_10.getText();
				if(!VerifyStoreNumber.validteStore(strnbr))
				{
					SupportUI.statuslabel.setText("invalid store number");
					MyLogger.log(Level.INFO, "enterd invalid store number: "+strnbr+"");
				}
				else
				{
					StrBankMnt.genStrBankMnt(strnbr);
					SupportUI.statuslabel.setText("mnt has been generated sucessfully");
					MyLogger.log(Level.INFO, "store bank reset mnt has genereted for the store: "+strnbr+"");
					textField_10.setText("");
				}
				
			}
		});
		
		return storebankpannel;
		
	}
}
