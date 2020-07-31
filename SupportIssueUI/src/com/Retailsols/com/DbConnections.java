package com.Retailsols.com;
import java.sql.SQLException;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class DbConnections {

	
	public static OracleConnection getStoreDBConnection(String pStoreNbr) throws SQLException {
		// create the Oracle DataSource and set the URL
		OracleDataSource ods = new OracleDataSource();
		ods.setServerName("CHAPOS" + pStoreNbr + "R01.corp.chartercom.com");
		ods.setUser("pos");
		ods.setPassword("mUpkVA5XM6fj");
		ods.setServiceName("xstore");
		ods.setPortNumber(1521);
		ods.setDriverType("thin");

		OracleConnection ocon = null;
		try
		{
			//connect to the database and turn off auto commit
			ocon = (OracleConnection) ods.getConnection();
			ocon.setAutoCommit(false);
		}
		catch(Exception e)
		{
			ocon = getXCDBConnection();
		}

		return ocon;
	}
	
	public static OracleConnection getXCDBConnection() throws SQLException {
		// create the Oracle DataSource and set the URL
		OracleDataSource ods = new OracleDataSource();
		ods.setServerName("ora-prod41.twcable.com");
		ods.setUser("MOBILE_POS");
		ods.setPassword("mBSEgJx_Y2sG");
		ods.setServiceName("spmxc01p_svc.corp.chartercom.com");
		ods.setPortNumber(1521);
		ods.setDriverType("thin");

		// connect to the database and turn off auto commit
		OracleConnection ocon = (OracleConnection) ods.getConnection();
		ocon.setAutoCommit(false);
		return ocon;
	}
}
