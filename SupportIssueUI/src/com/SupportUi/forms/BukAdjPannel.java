package com.SupportUi.forms;

import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.Retailsols.com.MyLogger;
import com.Retailsols.com.SupportUI;
import com.Retailsols.com.VerifyStoreNumber;
import com.retail.service.BukAdjMnt;
import com.retail.service.CountMnt;

public class BukAdjPannel {

	public static Panel getBukAdjPanel()
	{
		String[] str = { "select", "ON_HAND", "DAMAGED", "DEMO","EARLY_UPGRADE" ,"TRADE_IN"};
		Panel bucketadjpannel = new Panel();
		bucketadjpannel.setBackground(new Color(30, 144, 255));
		bucketadjpannel.setLayout(null);
		
		
		Label label_7 = new Label("Bucket Adjustment Issue");
		bucketadjpannel.add(label_7);
		
		Label label_14 = new Label("Store Number");
		label_14.setBounds(230, 66, 80, 22);
		bucketadjpannel.add(label_14);
		
		JTextField textField_11 = new JTextField();
		textField_11.setBounds(333, 66, 87, 22);
		bucketadjpannel.add(textField_11);
		
		Label label_15 = new Label("SKU");
		label_15.setBounds(278, 112, 35, 22);
		bucketadjpannel.add(label_15);
		
		JTextField textField_12 = new JTextField();
		textField_12.setBounds(333, 112, 87, 22);
		bucketadjpannel.add(textField_12);
		
		Label label_16 = new Label("IMEI");
		label_16.setBounds(278, 146, 35, 22);
		bucketadjpannel.add(label_16);
		
		JTextField textField_13 = new JTextField();
		textField_13.setBounds(333, 146, 87, 22);
		bucketadjpannel.add(textField_13);
		
		Label label_17 = new Label("Bucket");
		label_17.setBounds(272, 176, 41, 22);
		bucketadjpannel.add(label_17);
		
		JComboBox bct = new JComboBox(str);
		bct.setBounds(333, 178, 119, 20);
		bucketadjpannel.add(bct);
		
		JButton btnNewButton_3 = new JButton("Process");
		btnNewButton_3.setBackground(new Color(0, 128, 0));
		btnNewButton_3.setBounds(317, 236, 89, 23);
		bucketadjpannel.add(btnNewButton_3);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String strnbr=textField_11.getText();
				String sku=textField_12.getText();
				String imei=textField_13.getText();
				String bucket=(String) bct.getSelectedItem();
				
				if(!VerifyStoreNumber.validteStore(strnbr))
				{
					SupportUI.statuslabel.setText("invalid store number");
				}
				else
				{
					textField_11.setText("");
					textField_12.setText("");
					textField_13.setText("");
					bct.setToolTipText("");
					
					try {
						BukAdjMnt.imeiAdj(strnbr, sku, imei, bucket);
						SupportUI.statuslabel.setText("mnt has been generated sucessfully");
						MyLogger.log(Level.INFO, "bucket adjustment mnt has genereted for the store: "+strnbr+"");
					} catch (Exception e) {
						
						SupportUI.statuslabel.setText(" unable to connect to the database");
						
					} 
					
				}
				
			}
		});
		
		return bucketadjpannel;

	}
}
