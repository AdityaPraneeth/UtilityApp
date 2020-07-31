package com.SupportUi.validations;

public class TillValidattions {

	public static boolean validateTillNo(String tillno)
	{
		
		if(!tillno.startsWith("TILL"))
			return false;
		else if(tillno.length()!=6)
			return false;
		else
			return true;
		
	}

	public static boolean validateRegNo(String regno) {
		
		try {
		int reg_no = Integer.parseInt(regno);
		if(reg_no<30&&reg_no>0)
			return true;
		else
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
}
