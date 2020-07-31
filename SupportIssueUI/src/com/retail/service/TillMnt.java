package com.retail.service;

import java.io.File;
import java.io.PrintWriter;


public class TillMnt {

	public static void genTillMnt(String strnbr,String tillno,String tillstatus,String regno)
	{
		String dir="C:\\XstoreIssues\\MNT_FILES";
		try {
			PrintWriter pw = new PrintWriter(new File(
					dir + "\\" + strnbr + " _TillIssue"+ ".mnt"));
			StringBuilder sb=new StringBuilder();
			sb.append("<Header download_id='Till."+strnbr+""+".2019-12-10' target_org_node='STORE:"+strnbr+"' deployment_name='Till."+strnbr+".2020-06-19' download_time='IMMEDIATE' apply_immediately='true'/> ");
			sb.append("\n");
			sb.append("RUN_SQL|UPDATE TSN_SESSION_WKSTN SET ATTACHED_FLAG = '0'"+" WHERE WKSTN_ID='"+regno+"'"+" AND ATTACHED_FLAG='1'");
			sb.append("\n");
			sb.append("RUN_SQL|UPDATE TSN_TNDR_REPOSITORY_STATUS SET ISSUED_FLAG='0'"+", ACTIVE_SESSION_ID=''"+" WHERE TNDR_REPOSITORY_ID='"+tillno+"'");
			sb.append("\n");
			sb.append("RUN_SQL|DELETE TSN_SESSION WHERE STATCODE='"+tillstatus+"'"+" AND TNDR_REPOSITORY_ID='"+tillno+"'");
			sb.append("\n");
			sb.append("RUN_SQL|COMMIT");
			
			pw.write(sb.toString());
			pw.close();
			//UploadFile.upload();
			} catch (Exception e2) {
				
		  }
	}
}
