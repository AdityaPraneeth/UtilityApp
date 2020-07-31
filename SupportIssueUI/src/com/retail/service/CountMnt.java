package com.retail.service;

import java.io.File;
import java.io.PrintWriter;



public class CountMnt {

	public static void genCountMnt(String strnbr,String countid)
	{
		String dir="C:\\XstoreIssues\\MNT_FILES";
		try {
			PrintWriter pw = new PrintWriter(new File(
			dir + "\\" + strnbr  + " _Count"+ ".mnt"));
			StringBuilder br=new StringBuilder();
			br.append("<Header download_id='ON_HAND."+".2019-12-10' target_org_node='STORE:"+strnbr+"' deployment_name='ON_HAND."+"2019-12-10' download_time='IMMEDIATE' apply_immediately='true' />\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_COUNT WHERE RTL_LOC_ID='"+strnbr+"' AND INV_COUNT_ID ='"+countid+"'\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_COUNT_P WHERE RTL_LOC_ID='"+strnbr+"' AND INV_COUNT_ID ='"+countid+"'\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_COUNT_BUCKET WHERE RTL_LOC_ID='"+strnbr+"' AND INV_COUNT_ID='"+countid+"'\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_COUNT_BUCKET_P WHERE RTL_LOC_ID='"+strnbr+"' AND INV_COUNT_ID='"+countid+"'\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_COUNT_SHEET WHERE RTL_LOC_ID='"+strnbr+"' AND INV_COUNT_ID='"+countid+"'\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_COUNT_SHEET_P WHERE RTL_LOC_ID='"+strnbr+"' AND INV_COUNT_ID='"+countid+"'\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_COUNT_SHEET_LINEITM WHERE RTL_LOC_ID='"+strnbr+"' AND INV_COUNT_ID ='"+countid+ "'\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_COUNT_SHEET_LINEITM_P WHERE RTL_LOC_ID='"+strnbr+"' AND INV_COUNT_ID ='"+countid+ "'\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_COUNT_SNAPSHOT WHERE RTL_LOC_ID='"+strnbr+"' AND INV_COUNT_ID='"+countid+ "'\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_COUNT_SNAPSHOT_P WHERE RTL_LOC_ID='"+strnbr+"' AND INV_COUNT_ID='"+countid+ "'\n");
			br.append("RUN_SQL|COMMIT");
			pw.write(br.toString());
			pw.close();
		//	UploadFile.upload();
			
		}
			catch(Exception e) {
				
			}
	
	}
}
