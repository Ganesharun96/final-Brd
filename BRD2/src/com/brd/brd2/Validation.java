/*
 * class:validation
 * Version:valid v.0.1
 * Author:Ganesh
 * 
 */

package com.brd.brd2;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation
{ 
	static SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");
	public static boolean validDatatype(Object numeric )
	{

	if( numeric.getClass().getSimpleName().equals("Integer"))
	{
return true;
}
	else if( numeric.getClass().getSimpleName().equals("Double"))
	{
return true;
}
	if( numeric.getClass().getSimpleName().equals("Character"))
	{
return true;
}
	if( numeric.getClass().getSimpleName().equals("String"))
	{
return true;
}
	if( numeric.getClass().getSimpleName().equals("Boolean"))
	{
return true;
}
	return false;
	}
	public static boolean maxLength(short field,String object)
	{

if( (object.length())<=field)
		
	{
return true;
}
	return false;
	}
	public static boolean specialCharacters(String field)
	{

	Pattern pattern=Pattern.compile("[a-zA-Z0-9]+");
	Matcher matcher =pattern.matcher(field);
	if(matcher.matches())

return true;
	else
		return false;
	}
	public static boolean domainvalue(ArrayList list,String field) {
		
	
	if(list.contains(field))
	{return true;
	}return false;
	
}

	public static boolean email(String email)
	{
		if(email.contains("@")||email.contains("."))
		{
			if(!email.contains(" "))
			{
				return true;
			}
		}
		
		return false;
		
	}
	public static Boolean formatValidation(String field,SimpleDateFormat dates)
	{
		dates.setLenient(false);
		try
		{
			dates.parse(field);
			return true;
		}
		catch(ParseException e)
		{
			return false;
		}
	}
	
	public static void main(String[] args) { 
		 

		ArrayList<String> list=new ArrayList<String>();  
		list.add("mon");  
		list.add("tue");  
		list.add("wed");  
		list.add("thur");  
		System.out.println(validDatatype(12));
		System.out.println(maxLength((short)6,"1234567"));
		System.out.println(specialCharacters("$"));
		System.out.println(domainvalue(list,"mon"));
		
	   System.out.println(formatValidation("13/12/1997",dates));
	
		System.out.println(email("gary @nucl.com"));
	}
}
