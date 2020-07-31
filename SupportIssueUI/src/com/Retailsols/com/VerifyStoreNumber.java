package com.Retailsols.com;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.OracleConnection;

public class VerifyStoreNumber {
	
	public static boolean validteStore(String strnbr) 
	{
		ArrayList<String> storelist= new ArrayList<String>();
		
		try {
			//storelist=getStoresList();
			storelist.add("1001");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  // fetching the stores list from xcenter
		if(storelist.contains(strnbr))
		return true;
		else
		return false;
		
	}
	
private static ArrayList getStoresList() throws SQLException {
		
		OracleConnection ocon=DbConnections.getXCDBConnection();
		Statement stmt = ocon.createStatement();
		
		String query="SELECT DISTINCT DOC.RTL_LOC_ID FROM DTV.INV_INVCTL_DOCUMENT DOC "
				+  " INNER JOIN DTV.LOC_RTL_LOC RTL ON RTL.ORGANIZATION_ID = DOC.ORGANIZATION_ID"
				+ " AND RTL.RTL_LOC_ID = DOC.RTL_LOC_ID WHERE DOC.DOCUMENT_SUBTYPCODE = 'ASN' ORDER BY DOC.RTL_LOC_ID";
		
		ResultSet rset = stmt.executeQuery(query);
		
		ArrayList<String> stores = new ArrayList<>();

		while (rset.next()) 
		{
			stores.add(rset.getString(1));
		}
		
		return stores;
	}

}
