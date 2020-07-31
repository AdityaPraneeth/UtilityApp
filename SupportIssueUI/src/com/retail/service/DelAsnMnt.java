package com.retail.service;

import java.io.File;
import java.io.PrintWriter;



public class DelAsnMnt {

	public static void genDelAsnMnt(String strnbr,String asnid)
	{
		String dir="C:\\XstoreIssues\\MNT_FILES";
		try {
			PrintWriter pw = new PrintWriter(new File(
			dir + "\\" + strnbr  + " _Delete_Asn"+ ".mnt"));
			StringBuilder br=new StringBuilder();
			br.append("<Header download_id='ON_HAND..2019-12-10' target_org_node='STORE:"+strnbr+"' deployment_name='ON_HAND.2019-12-10' download_time='IMMEDIATE' apply_immediately='true' />");
			br.append("\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_INVCTL_DOCUMENT WHERE INVCTL_DOCUMENT_ID ='"+asnid+"' AND RTL_LOC_ID='"+strnbr+"' AND DOCUMENT_SUBTYPCODE='ASN'");
			br.append("\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_CARTON WHERE INVCTL_DOCUMENT_ID ='"+asnid+"' AND RTL_LOC_ID='"+strnbr+"'");
			br.append("\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_INVCTL_DOCUMENT_LINEITM WHERE INVCTL_DOCUMENT_ID ='"+asnid+"' AND RTL_LOC_ID='"+strnbr+"'");
			br.append("\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_INVCTL_TRANS WHERE INVCTL_DOCUMENT_ID ='"+asnid+"' AND RTL_LOC_ID='"+strnbr+"'");
			br.append("\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_INVCTL_TRANS_DETAIL WHERE INVCTL_DOCUMENT_ID ='"+asnid+"' AND RTL_LOC_ID='"+strnbr+"'");
			br.append("\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_INVCTL_DOC_LINESERIAL WHERE INVCTL_DOCUMENT_ID ='"+asnid+"' AND RTL_LOC_ID='"+strnbr+"'");
			br.append("\n");
			br.append("RUN_SQL|DELETE FROM DTV.INV_INVENTORY_LOC_MOD WHERE DOCUMENT_ID ='"+asnid+"' AND RTL_LOC_ID='"+strnbr+"'");
			br.append("\n");
			br.append("RUN_SQL|COMMIT");
			pw.write(br.toString());
			pw.close();
		//	UploadFile.upload();
			
		}
			catch(Exception e) {
				
			}

	}
}
