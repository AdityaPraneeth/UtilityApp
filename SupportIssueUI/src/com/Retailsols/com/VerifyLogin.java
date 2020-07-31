package com.Retailsols.com;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class VerifyLogin {
	public static boolean athuntecate(String userid, String password) {    
	    
		boolean flag=false;
	      Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.port", "587"); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

	   // creates a new session with an authenticator
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userid, password);
	            }
	        };
	        
	      // Get the default Session object.
	      Session session = Session.getInstance(props,auth);
	      try 
	      {
			Store s=session.getStore("imaps");
			s.connect("smtp.gmail.com",userid,password);
			flag=s.isConnected();
	      }
	      catch (Exception e) 
	      {
	    	  
			return false;
	      } 
	      
	      return flag;
	   }
	}

