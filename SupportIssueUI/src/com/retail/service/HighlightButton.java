package com.retail.service;

import java.awt.Color;

import com.Retailsols.com.SupportUI;

public class HighlightButton {

	public static void highlightTill()
	{
		SupportUI.statuslabel.setText("");
		SupportUI.tillissue.setBackground(new Color(30, 144, 255));
		SupportUI.bdissuebtn.setBackground(new Color(128, 128, 128));
		SupportUI.stbank.setBackground(new Color(128, 128, 128));
		SupportUI.delasnbutton.setBackground(new Color(128, 128, 128));
		SupportUI.countbt.setBackground(new Color(128, 128, 128));
		SupportUI.bktadjbt.setBackground(new Color(128, 128, 128));
	}
	public static void highlightCount()
	{
		SupportUI.statuslabel.setText("");
		SupportUI.countbt.setBackground(new Color(30, 144, 255));
		SupportUI.bdissuebtn.setBackground(new Color(128, 128, 128));
		SupportUI.stbank.setBackground(new Color(128, 128, 128));
		SupportUI.delasnbutton.setBackground(new Color(128, 128, 128));
		SupportUI.tillissue.setBackground(new Color(128, 128, 128));
		SupportUI.bktadjbt.setBackground(new Color(128, 128, 128));
	}
	public static void highlightDelAsn()
	{
		SupportUI.statuslabel.setText("");
		SupportUI.delasnbutton.setBackground(new Color(30, 144, 255));
		SupportUI.bdissuebtn.setBackground(new Color(128, 128, 128));
		SupportUI.stbank.setBackground(new Color(128, 128, 128));
		SupportUI.countbt.setBackground(new Color(128, 128, 128));
		SupportUI.tillissue.setBackground(new Color(128, 128, 128));
		SupportUI.bktadjbt.setBackground(new Color(128, 128, 128));
	}
	public static void highlightStrBnk()
	{
		SupportUI.statuslabel.setText("");
		SupportUI.stbank.setBackground(new Color(30, 144, 255));
		SupportUI.bdissuebtn.setBackground(new Color(128, 128, 128));
		SupportUI.delasnbutton.setBackground(new Color(128, 128, 128));
		SupportUI.countbt.setBackground(new Color(128, 128, 128));
		SupportUI.tillissue.setBackground(new Color(128, 128, 128));
		SupportUI.bktadjbt.setBackground(new Color(128, 128, 128));
	}
	public static void highlightBsnDat()
	{
		SupportUI.statuslabel.setText("");
		SupportUI.bdissuebtn.setBackground(new Color(30, 144, 255));
		SupportUI.stbank.setBackground(new Color(128, 128, 128));
		SupportUI.delasnbutton.setBackground(new Color(128, 128, 128));
		SupportUI.countbt.setBackground(new Color(128, 128, 128));
		SupportUI.tillissue.setBackground(new Color(128, 128, 128));
		SupportUI.bktadjbt.setBackground(new Color(128, 128, 128));
	}
	public static void highlightBukAdj()
	{
		SupportUI.statuslabel.setText("");
		SupportUI.bktadjbt.setBackground(new Color(30, 144, 255));
		SupportUI.tillissue.setBackground(new Color(128, 128, 128));
		SupportUI.bdissuebtn.setBackground(new Color(128, 128, 128));
		SupportUI.stbank.setBackground(new Color(128, 128, 128));
		SupportUI.delasnbutton.setBackground(new Color(128, 128, 128));
		SupportUI.countbt.setBackground(new Color(128, 128, 128));
	}
}
