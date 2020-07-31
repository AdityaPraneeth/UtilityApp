package com.retail.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Retailsols.com.DbConnections;

import oracle.jdbc.OracleConnection;

public class BukAdjMnt {

	private static int qty;

	public static void imeiAdj(String strnbr,String sku,String imei,String bucket) throws SQLException, FileNotFoundException 
	{
		
		OracleConnection ocon=DbConnections.getStoreDBConnection(strnbr);
		Statement stmt = ocon.createStatement();
		
		String Dbucket=""; String Dsku="";  String strqty=""; boolean adjusted=false; boolean skuexists =false;
		
		String sql="select item_id,bucket_id from dtv.inv_serialized_stock_ledger where serial_nbr='"+imei+"' AND rtl_loc_id='"+strnbr+"'";
		
		ResultSet rset = stmt.executeQuery(sql);
		
		String dir="C:\\XstoreIssues\\MNT_FILES";
		PrintWriter pw = new PrintWriter(new File(dir + "\\" + strnbr + " _invadj"+ ".mnt"));
		StringBuilder sb=new StringBuilder();
		
		if(rset.next())
		{
			Dsku=rset.getString(1);
			Dbucket=rset.getString(2);
			
			if((!Dsku.equals(sku))||(!Dbucket.equals(bucket)))  // imei is in incorrect sku & bucket
			{
				adjusted=true;
				sb.append("RUN_SQL|UPDATE DTV.INV_SERIALIZED_STOCK_LEDGER SET ITEM_ID='"+sku+"', BUCKET_ID='"+bucket+"', UPDATE_USER_ID='SUPPORTTEAM' WHERE SERIAL_NBR='"+imei+"' AND RTL_LOC_ID='"+strnbr+"' AND ORGANIZATION_ID='1'");
			}
			
		}
		else
		{
			adjusted=true;
			sb.append("RUN_SQL|INSERT into DTV.inv_serialized_stock_ledger values (1," + strnbr + ",'DEFAULT', '" + bucket + "','" + sku + "','" + imei + "',TO_DATE(sysdate, 'dd/mm/yyyy hh24:mi:ss'),'SUPPORTTEAM',TO_DATE(sysdate, 'dd/mm/yyyy hh24:mi:ss'),'SUPPORTTEAM', null)");
			
		}
		
		skuexists=getqty(strnbr,Dsku,Dbucket); //fetches the imeis count from serial ledger
		
		if(skuexists&&adjusted)    // updating the qty sku 
		{
			strqty=Integer.toString(qty+1);
			sb.append("RUN_SQL|UPDATE DTV.inv_stock_ledger_acct SET UNITCOUNT='"+strqty+"' where item_id='"+Dsku+"' AND bucket_id='"+Dbucket+"' AND rtl_loc_id='"+strnbr+"'");
		}
		else if((!skuexists)&&adjusted)   // inserting the sku
		{
			strqty=Integer.toString(qty+1);
			sb.append("RUN_SQL|INSERT INTO DTV.INV_STOCK_LEDGER_ACCT VALUES ('1','"+strnbr+"','DEFAULT','"+bucket+"','"+sku+"','1','',SYSDATE,'SUPPORTTEAM',SYSDATE,'SUPPORTTEAM','') ");
			
		}
		
		pw.write(sb.toString());
	
		
		
	}

	private static boolean getqty(String strnbr, String sku, String bucket) throws SQLException {
		
		OracleConnection ocon=DbConnections.getStoreDBConnection(strnbr);
		Statement stmt = ocon.createStatement();
		
		
		
		String sql="select UNITCOUNT from dtv.inv_stock_ledger_acct where item_id='"+sku+"' AND bucket_id='"+bucket+"' AND rtl_loc_id='"+strnbr+"";
		
		ResultSet res = stmt.executeQuery(sql);
		
		if(res.next())
		{
			qty=res.getInt(1);
			return true;
		}
		else
		{
			qty=0;
			return false;
		}
		
		
	}

}
