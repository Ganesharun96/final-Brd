package reccords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Recordlevel {
	static ArrayList<String> listOfLines = new ArrayList<>();
 
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String file = "D:\\File1.txt";
		if(file.endsWith(".txt"))
		{

		  FileReader filereader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			String string;

			while ((string = bufferedReader.readLine()) != null) {
				string+="~";
				listOfLines.add(string);

			} 
			
			String[] fields = new  String[16];
			int count=0;
			for(int i =0;i<listOfLines.size();i++) {
				String record = listOfLines.get(i);	
               String[] sepratingUptoSplilt = record.split("(?<=~)");
               

				for(int j=0;j<16;j++)  
				{
					fields[j]=sepratingUptoSplilt[j].substring(0, sepratingUptoSplilt[j].lastIndexOf("~"));
					System.out.println(fields[j]);
				
					
				}
				
			if(validator(fields)==true)
			{
				database.customer( Integer.toString(count +=1),fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10],fields[11],fields[12],fields[13],fields[14],fields[15]);
				
			}
			else {
				System.out.println("err");
			}

//				for (String str : strings) {
//					
//					
//					System.out.println(str);
//				}
//		System.out.println(customername(removed[2]));
			
				
        }
	
			
			
		}else
			System.out.println("incorrect format");


	}
	
		
	public static boolean validator(String[] fields)
	{
		boolean pincodes= pincode(fields[4]);
		boolean customernames=customername(fields[1]);
		boolean emails=email(fields[5]);
		boolean RecordStatuss=RecordStatus(fields[8]);
		boolean flags=flag(fields[9]);
		
		if( pincodes&&customernames&&emails&&RecordStatuss&&flags)
		{
			return true;
		}
		return false;
	}

	public static boolean pincode(String pincode) {
		if (pincode.length() == 6) {
			return true;
		} else
			return false;
	}

	public static boolean customername(String customername) {

		Pattern pattern = Pattern.compile("[a-zA-Z0-9]");
		if (pattern.matcher(customername).find()) {
			return true;
		} 
			return false;
	}

	public static boolean email(String email)
	{
		if (email.contains("@")&&email.contains("."))
		{
			return true;
		} else
			return false;
	}
	public static boolean RecordStatus(String recordstatus)
	{
		if (recordstatus.contains("N")||recordstatus.contains("M")||recordstatus.contains("D")||recordstatus.contains("A")||recordstatus.contains("R"))
		{
			return true;
		} else
			return false;
	}
	public static boolean flag(String flag)
	{
		if (flag.contains("A")||flag.contains("I"))
		{
			return true;
		} else
			return false;
	}
	}

//customername(ss[1].substring(0, ss[1].lastIndexOf("~")));
//pincode(ss[3].substring(0, ss[3].lastIndexOf("~")));
//email(ss[5].substring(0, ss[5].lastIndexOf("~")));
//for(int j=0;j<=0;j++)
//{
//	customername(ss[j+1].substring(0, ss[j+1].lastIndexOf("~")));
//	pincode(ss[j+4].substring(0, ss[j+4].lastIndexOf("~")));
//	email(ss[j+5].substring(0, ss[j+5].lastIndexOf("~")));
//	System.out.println("\n");
//}
//String s1 = listOfLines.get(i);
//String[] ss = s1.split("(?<=~)");

//customername(ss[1].substring(0, ss[1].lastIndexOf("~")));
//pincode(ss[3].substring(0, ss[3].lastIndexOf("~")));
//email(ss[5].substring(0, ss[5].lastIndexOf("~")));
//


//while ((s = br.readLine()) != null) {
//	listOfLines.add(s);
//
//}
//for(int i =0;i<listOfLines.size();i++) {
//	String s1 = listOfLines.get(i);	
////	s1+="";
//	String[] ss = s1.split("(?<=~)");
//	String[] strings = new  String[16];
//	System.out.println("******************\n");
//
//	for(int j=0;j<15;j++)  
//	{
//		String remove = ss[j].substring(0, ss[j].lastIndexOf("~"));
//		strings[j] = remove; 
//		
//	}
//	if(strings[15] == null) {
//		strings[15]="";
//	}
