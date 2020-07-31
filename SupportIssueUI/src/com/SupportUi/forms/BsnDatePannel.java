package com.SupportUi.forms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.Retailsols.com.MyLogger;
import com.Retailsols.com.SupportUI;
import com.Retailsols.com.VerifyStoreNumber;
import com.retail.service.BsnDateMnt;

public class BsnDatePannel {

	private static String cdt;
	private static String cmt;
	private static String cyr;
	
	private static String wdt;
	private static String wmt;
	private static String wyr;
	
	private static JTextField textField_2;
	private static String store_number;

	private static String[] date= {"date", "01", "02", "03", "04", "05", "06","07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	private static String[] month= {"month", "JAN", "FEB", "MAR", "APR", "MAY", "JUN","JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	private static String[] year= {"year", "2019", "2020", "2021"};
	
	public static Panel getBsnDatePanel()
	{
		
		Panel businessdatepanel = new Panel();
		businessdatepanel.setBackground(new Color(30, 144, 255));
		businessdatepanel.setLayout(null);
		
		
		
		
		Label storeNumber = new Label("Store Number");
		storeNumber.setFont(new Font("Dialog", Font.PLAIN, 14));
		storeNumber.setForeground(Color.WHITE);
		storeNumber.setBounds(172, 52, 98, 22);
		businessdatepanel.add(storeNumber);
		
		textField_2 = new JTextField();
		textField_2.setBounds(282, 52, 86, 20);
		businessdatepanel.add(textField_2);
		textField_2.setColumns(10);
		
		
		Label wrongDate = new Label("Wrong Date");
		wrongDate.setFont(new Font("Dialog", Font.PLAIN, 14));
		wrongDate.setForeground(Color.WHITE);
		wrongDate.setBounds(172, 96, 89, 22);
		businessdatepanel.add(wrongDate);
		
		JComboBox Wdate = new JComboBox(date);
		Wdate.setBounds(282, 98, 54, 20);
		businessdatepanel.add(Wdate);
		
		JComboBox Wmonth = new JComboBox(month);
		Wmonth.setBounds(346, 98, 61, 20);
		businessdatepanel.add(Wmonth);
		
		JComboBox Wyear = new JComboBox(year);
		Wyear.setBounds(415, 98, 54, 20);
		businessdatepanel.add(Wyear);
		
		
		
		
		Label correctDate = new Label("Correct Date");
		correctDate.setFont(new Font("Dialog", Font.PLAIN, 14));
		correctDate.setForeground(Color.WHITE);
		correctDate.setBounds(172, 139, 89, 22);
		businessdatepanel.add(correctDate);
		
		JComboBox Cdate = new JComboBox(date);
		Cdate.setBounds(283, 141, 53, 20);
		businessdatepanel.add(Cdate);
		
		JComboBox Cmonth = new JComboBox(month);
		Cmonth.setBounds(346, 141, 61, 20);
		businessdatepanel.add(Cmonth);
		
		JComboBox Cyear = new JComboBox(year);
		Cyear.setBounds(413, 141, 56, 20);
		businessdatepanel.add(Cyear);
		
		
		JButton processButton = new JButton("Process");
		processButton.setBackground(new Color(0, 128, 0));
		processButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				MyLogger.log(Level.INFO, "Clicked process button");

				cdt=(String)Cdate.getSelectedItem();
				cmt=(String)Cmonth.getSelectedItem();
				cyr=(String)Cyear.getSelectedItem();
				
				 wdt=(String)Wdate.getSelectedItem();//+(String)Wmonth.getSelectedItem()+(String)Wyear.getSelectedItem();
				 wmt=(String)Wmonth.getSelectedItem();
				 wyr=(String)Wyear.getSelectedItem();
				
				String Cdata=cdt+"-"+cmt+"-"+cyr;
				String wdata=wdt+"-"+wmt+"-"+wyr;
				
								 
				 store_number = textField_2.getText();
		
				
				if(VerifyStoreNumber.validteStore(store_number))  //
				{
					if(cdt.equals(date[0])||cmt.equals(month[0])||cyr.equals(year[0])
						||wdt.equals(date[0])||wmt.equals(month[0])||wyr.equals(year[0]))
					{
						
						SupportUI.statuslabel.setText("invalid date");
					}
					else
					{
						BsnDateMnt.genBsnDateMnt(store_number, wdata, Cdata);
						SupportUI.statuslabel.setText("mnt has been generated");
						MyLogger.log(Level.INFO, "correct date: "+Cdata+"\n wrong date: "+wdata);
					}
						
				
				}
				else
				{
					SupportUI.statuslabel.setText("invalid store number");
				}
				
				
				textField_2.setText("");
				MyLogger.log(Level.INFO, "re-set business date mnt file is generated");
			}
		});
		processButton.setBounds(247, 187, 89, 23);
		businessdatepanel.add(processButton);
		
		return businessdatepanel;
	}
}
