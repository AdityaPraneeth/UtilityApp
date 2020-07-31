package com.retail.service;

import java.io.File;
import java.io.PrintWriter;


public class StrBankMnt {

	public static void genStrBankMnt(String strnbr)
	{
		String dir="C:\\XstoreIssues\\MNT_FILES";
		try {
			PrintWriter pw = new PrintWriter(new File(
			dir + "\\" + strnbr + " _Storebank"+ ".mnt"));
			StringBuilder br=new StringBuilder();
			br.append("RUN_SQL|UPDATE DTV.TSN_SESSION_TNDR SET ACTUAL_MEDIA_AMT='0' WHERE TNDR_ID='USD_CURRENCY' AND SESSION_ID='0'");
			br.append("\n");
			br.append("RUN_SQL|COMMIT");
			pw.write(br.toString());
			pw.close();
			//UploadFile.upload();
			
		}
			catch(Exception e) {
				
			}
	}
}
