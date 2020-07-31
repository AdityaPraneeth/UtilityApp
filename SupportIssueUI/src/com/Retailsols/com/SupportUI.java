package com.Retailsols.com;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.SupportUi.forms.BsnDatePannel;
import com.SupportUi.forms.BukAdjPannel;
import com.SupportUi.forms.CountPannel;
import com.SupportUi.forms.DelAsnPannel;
import com.SupportUi.forms.StrBankPannel;
import com.SupportUi.forms.TillPannel;
import com.retail.service.HighlightButton;

public class SupportUI extends JFrame {

	
	public static JLabel statuslabel;
	
	public static String user_id;
	public static String user_name;
	
	public static Button tillissue;
	public static Button bdissuebtn;
	public static Button stbank;
	public static Button countbt;
	public static Button bktadjbt;
	public static Button delasnbutton;
	
	private JPanel contentPane;
	JLabel lblDate = new JLabel("Date :");

	public static void launch(String userid, String name) {
		
		user_id=userid;
		user_name=name;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupportUI frame = new SupportUI();
				    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				    frame.setSize(screenSize.width, screenSize.height);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public void date() {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-YYYY");
		lblDate.setText(sdf.format(d));
	}


	
	public   SupportUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Capture.JPG"));
		setTitle("XstoreSuportUtility");
		date();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 755);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		 tillissue = new Button("TILL ISSUE");
		
		tillissue.setBounds(0, 50, 269, 85);
		tillissue.setForeground(Color.WHITE);
		tillissue.setBackground(new Color(128, 128, 128));
		contentPane.add(tillissue);
		
		 bdissuebtn = new Button("BUSINESS DATE ISSUE");
		bdissuebtn.setBounds(0, 135, 269, 85);
		bdissuebtn.setForeground(Color.WHITE);
		bdissuebtn.setBackground(new Color(128, 128, 128));
		contentPane.add(bdissuebtn);
		

		
		 stbank = new Button("STORE BANK ISSUE");
		stbank.setBounds(0, 221, 269, 85);
		stbank.setForeground(Color.WHITE);
		stbank.setBackground(new Color(128, 128, 128));
		contentPane.add(stbank);
		
		 countbt = new Button("COUNT ISSUE");
		countbt.setBounds(0, 306, 269, 85);
		countbt.setForeground(Color.WHITE);
		countbt.setBackground(new Color(128, 128, 128));
		contentPane.add(countbt);
		
		 bktadjbt = new Button("BUCKET ADJUSTMENT");
		bktadjbt.setBounds(0, 391, 269, 93);
		bktadjbt.setForeground(Color.WHITE);
		bktadjbt.setBackground(new Color(128, 128, 128));
		contentPane.add(bktadjbt);
		
		 delasnbutton = new Button("DELETE ASN");
		delasnbutton.setForeground(Color.WHITE);
		delasnbutton.setBackground(Color.GRAY);
		delasnbutton.setBounds(0, 485, 269, 93);
		contentPane.add(delasnbutton);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 580, 1367, 67);
		panel_1.setBackground(new Color(0, 0, 0));
		
		panel_1.setLayout(null);
		
		statuslabel = new JLabel("");
		statuslabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		statuslabel.setHorizontalAlignment(SwingConstants.CENTER);
		statuslabel.setForeground(Color.RED);
		statuslabel.setBounds(399, 23, 477, 36);
		panel_1.add(statuslabel);
		contentPane.add(panel_1);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 648, 581, 80);
		panel_2.setBackground(SystemColor.controlHighlight);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		Label username = new Label("User Name:");
		username.setFont(new Font("Dialog", Font.BOLD, 16));
		username.setForeground(Color.black);
		username.setBounds(10, 22, 93, 22);
		panel_2.add(username);
		
		Label label_8 = new Label(user_name);
		label_8.setFont(new Font("Dialog", Font.BOLD, 16));
		label_8.setForeground(Color.black);
		label_8.setBounds(100, 22, 122, 22);
		panel_2.add(label_8);
		
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(746, 649, 620, 67);
		panel_3.setBackground(SystemColor.controlHighlight);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		Label pid = new Label("PID:");
		pid.setFont(new Font("Dialog", Font.BOLD, 16));
		pid.setForeground(Color.black);
		pid.setBounds(444, 21, 42, 22);
		panel_3.add(pid);
		
		Label label_5 = new Label(user_id);
		label_5.setFont(new Font("Dialog", Font.BOLD, 16));
		label_5.setForeground(Color.black);
		label_5.setBounds(488, 21, 77, 22);
		panel_3.add(label_5);
		
		
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(579, 648, 167, 68);
		panel_4.setBackground(new Color(34, 139, 34));
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(44, 11, 84, 40);
		panel_4.add(lblDate);
		
		Panel panel_5 = new Panel();
		panel_5.setBounds(0, 0, 1400, 51);
		panel_5.setBackground(new Color(204, 153, 0));
		contentPane.add(panel_5);
		
		Label label_3 = new Label("Retail Sols-Xstore Support Utility");
		label_3.setForeground(Color.black);
		label_3.setFont(new Font("Dialog", Font.BOLD, 36));
		panel_5.add(label_3);		
		
		Panel panel_6 = new Panel();
		panel_6.setForeground(new Color(255, 255, 255));
		panel_6.setBounds(299, 82, 627, 349);
		contentPane.add(panel_6);
		panel_6.setLayout(new CardLayout(0, 0));
		
		CardLayout cardlyout=(CardLayout)panel_6.getLayout();
		
		Panel tillpanel=TillPannel.getTillPannel();
		panel_6.add(tillpanel, "till");
		
		Panel businessdatepanel=BsnDatePannel.getBsnDatePanel();
		panel_6.add(businessdatepanel, "businessdate");
		
		Panel countpannel=CountPannel.getCountPanel();
		panel_6.add(countpannel, "count");
		
		Panel storebankpannel = StrBankPannel.getStrBankPanel();
		panel_6.add(storebankpannel, "storebank");
		
		Panel bucketadjpannel = BukAdjPannel.getBukAdjPanel();
		panel_6.add(bucketadjpannel, "bucketadj");
		
		Panel delasn = DelAsnPannel.getDelAsnPanel();
		panel_6.add(delasn, "delasn");
		
		
		
		
		tillissue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HighlightButton.highlightTill();
				MyLogger.log(Level.INFO, "selected the till issue");
				cardlyout.show(panel_6, "till");
				
			}
		});
		bdissuebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HighlightButton.highlightBsnDat();
				MyLogger.log(Level.INFO, "selected the business date issue");
				cardlyout.show(panel_6, "businessdate");
				
			}
		});
		stbank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HighlightButton.highlightStrBnk();
				MyLogger.log(Level.INFO, "selected the store bank issue");
				cardlyout.show(panel_6, "storebank");
				
			}
		});
		countbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HighlightButton.highlightCount();
				MyLogger.log(Level.INFO, "selected the count isssue");
				cardlyout.show(panel_6, "count");
				
			}
		});
		bktadjbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HighlightButton.highlightBukAdj();
				MyLogger.log(Level.INFO, "selected the bucket adjustment ");
				cardlyout.show(panel_6, "bucketadj");
				
			}
		});
		delasnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HighlightButton.highlightDelAsn();
				MyLogger.log(Level.INFO, "selected the asn issue");
				cardlyout.show(panel_6, "delasn");
				
			}
		});
	}
}

