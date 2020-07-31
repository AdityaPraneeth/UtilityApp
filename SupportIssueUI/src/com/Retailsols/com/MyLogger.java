package com.Retailsols.com;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {

	static Logger logger;
    public Handler fileHandler;
    Formatter plainText;
    
    public MyLogger() throws IOException{
        //instance the logger
        logger = Logger.getLogger(MyLogger.class.getName());
        //instance the filehandler
        fileHandler = new FileHandler("C:\\XstoreIssues\\log\\"+getDate()+"-Support-Utility-Log.txt",true);
        //instance formatter, set formatting, and handler
        plainText = new SimpleFormatter();
        fileHandler.setFormatter(plainText);
        logger.addHandler(fileHandler);

    }
    
    private static Logger getLogger(){
        if(logger == null){
            try {
				new MyLogger();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        }
        return logger;
    }
    public static void log(Level level, String msg){
        getLogger().log(level, msg);
        //System.out.println(msg);
    }
    public static String getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		return dateFormat.format(new Date());

	}
}
