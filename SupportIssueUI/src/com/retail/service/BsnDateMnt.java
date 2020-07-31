package com.retail.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BsnDateMnt {

	public static void genBsnDateMnt(String store_number,String wdt,String cdt)
	{
		   System.out.println();
		   try {
			PrintWriter pw=new PrintWriter(new File("C:\\XstoreIssues\\MNT_FILES\\"+store_number+"_resetdate.mnt"));
			StringBuilder ds = new StringBuilder();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date dateobj = new Date();
			String date = new String(df.format(dateobj));
			
			//Query for updating the wrong date 
			
			ds.append("<Header download_id='Till."+store_number+""+"."+date+"' target_org_node='STORE:"+store_number+"' deployment_name='Till."+store_number+"."+date+"' download_time='IMMEDIATE' apply_immediately='true' /> ");
			ds.append("\n");
			
			ds.append("RUN_SQL|UPDATE DTV.loc_state_journal set DATE_VALUE="+cdt+" where DATE_VALUE="+wdt+"  and RTL_LOC_ID="+store_number+" and STATUS_TYPCODE='BUSINESS_DATE' and STATE_JOURNAL_ID in ('0000000187')");
			ds.append("\n");
			
			ds.append("RUN_SQL|update Dtv.inv_count set END_DATE="+cdt+" where END_DATE="+wdt+" and RTL_LOC_ID="+store_number);
			ds.append("\n");
			
			ds.append("RUN_SQL|update DTV.INV_COUNT_SNAPSHOT set snapshot_date ="+cdt+" where snapshot_date ="+wdt+"and RTL_LOC_ID="+store_number);
			ds.append("\n");
			
			ds.append("RUN_SQL|update dtv.inv_invctl_document set last_activity_date="+cdt+" where last_activity_date="+wdt+"and RTL_LOC_ID="+store_number);
			ds.append("\n");
			
			ds.append("RUN_SQL|update dtv.INV_SHIPMENT set ACTUAL_DELIVERY_DATE="+cdt+" where ACTUAL_DELIVERY_DATE="+wdt+" and RTL_LOC_ID="+store_number);
			ds.append("\n");
			
			ds.append("RUN_SQL|UPDATE DTV.TRN_TRANS SET BUSINESS_DATE="+cdt+"WHERE BUSINESS_DATE="+wdt+" AND RTL_LOC_ID="+store_number);
			ds.append("\n");
			ds.append("RUN_SQL|UPDATE DTV.SEC_ACTIVITY_LOG SET BUSINESS_DATE="+cdt+" WHERE BUSINESS_DATE="+wdt+" AND RTL_LOC_ID="+store_number);
			ds.append("\n");
			ds.append("RUN_SQL|UPDATE DTV.INV_INVENTORY_JOURNAL SET BUSINESS_DATE="+cdt+" WHERE BUSINESS_DATE="+wdt+" AND RTL_LOC_ID="+store_number);
			ds.append("\n");
			ds.append("RUN_SQL|UPDATE DTV.INV_INVCTL_TRANS_DETAIL SET BUSINESS_DATE="+cdt+" WHERE BUSINESS_DATE="+wdt+" AND RTL_LOC_ID="+store_number);
			ds.append("\n");
			ds.append("RUN_SQL|UPDATE DTV.INV_INVCTL_TRANS SET BUSINESS_DATE="+cdt+" WHERE BUSINESS_DATE="+wdt+"  AND RTL_LOC_ID="+store_number);
			ds.append("\n");
			ds.append("RUN_SQL|UPDATE DTV.INV_INVCTL_DOCUMENT_LINEITM SET LINEITM_BUSINESS_DATE="+cdt+" WHERE LINEITM_BUSINESS_DATE="+wdt+" AND RTL_LOC_ID="+store_number);
			ds.append("\n");
			ds.append("RUN_SQL|UPDATE DTV.CTL_DEVICE_REGISTRATION SET BUSINESS_DATE="+cdt+" WHERE BUSINESS_DATE="+wdt+"  AND RTL_LOC_ID="+store_number);
			ds.append("\n");
			ds.append("RUN_SQL|UPDATE DTV.CTL_EVENT_LOG SET BUSINESS_DATE="+cdt+" where  RTL_LOC_ID="+store_number+"BUSINESS_DATE="+wdt);
			ds.append("\n");
			
			ds.append("COMMIT" );
			
			
			pw.write(ds.toString());
			pw.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
}
