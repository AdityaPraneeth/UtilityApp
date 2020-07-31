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
import com.retail.service.DelAsnMnt;
import com.retail.service.StrBankMnt;

public class DelAsnPannel {
	
	private static String strnbr;
	private static String asnid;

	public static Panel getDelAsnPanel()
	{
		Panel delasn = new Panel();
		delasn.setBackground(new Color(30, 144, 255));
		delasn.setLayout(null);
	
		
		Label label_12 = new Label("Store Number");
		label_12.setBounds(212, 52, 80, 22);
		delasn.add(label_12);
		
		JTextField textField_8 = new JTextField();
		textField_8.setBounds(309, 52, 89, 22);
		delasn.add(textField_8);
		
		Label label_13 = new Label("ASN Document Number");
		label_13.setBounds(167, 93, 125, 22);
		delasn.add(label_13);
		
		JTextField textField_9 = new JTextField();
		textField_9.setBounds(309, 93, 89, 22);
		delasn.add(textField_9);
		
		JButton btnNewButton_1 = new JButton("Process");
		btnNewButton_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1.setBounds(244, 162, 89, 23);
		delasn.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				strnbr=textField_8.getText();
				asnid=textField_9.getText();
				if(!VerifyStoreNumber.validteStore(strnbr))
				{
					SupportUI.statuslabel.setText("invalid store number");
					MyLogger.log(Level.INFO, "enterd invalid store number: "+strnbr+"");
				}
				else
				{
					DelAsnMnt.genDelAsnMnt(strnbr, asnid);
					SupportUI.statuslabel.setText("mnt has been generated sucessfully");
					MyLogger.log(Level.INFO, "delete asn mnt has genereted for the store: "+strnbr+"");
					
					textField_8.setText("");
					textField_9.setText("");
				}
				
			}
		});
		return delasn;
	}
}
