package reccords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filelevel {
	static ArrayList<String> listOfLines = new ArrayList<>();
	static String[] fields = new String[16];
	

	public static void main(InputStream fileContent,String file) throws IOException, ClassNotFoundException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
		if (file.endsWith(".txt")) {
//
//			FileReader filereader = new FileReader(file);
//			BufferedReader bufferedReader = new BufferedReader(filereader);
			String string;
		

			while ((string = reader.readLine()) != null) {
				string += "~";
				listOfLines.add(string);

			} 

			
		 int count = 0;
			for (int i = 0; i < listOfLines.size(); i++) {
				String record = listOfLines.get(i);
				String[] sepratingUptoSplilt = record.split("(?<=~)");

				for (int j = 0; j < 16; j++) {
					fields[j] = sepratingUptoSplilt[j].substring(0, sepratingUptoSplilt[j].lastIndexOf("~"));
					System.out.println(fields[j]);

				}

				if (validator(fields) == false) {
				return ; 
				}
			}
			//database.customer( Integer.toString(count +=1),fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10],fields[11],fields[12],fields[13],fields[14],fields[15]);		
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
		
				
        }
		}
//		database.customer( Integer.toString(count +=1),fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10],fields[11],fields[12],fields[13],fields[14],fields[15]);		
		
	

	}

	public static boolean validator(String[] fields) {
		boolean pincodes = pincode(fields[4]);
		boolean customernames = customername(fields[1]);
		boolean emails = email(fields[5]);
		boolean RecordStatuss = RecordStatus(fields[8]);
		boolean flags = flag(fields[9]);

		if (pincodes && customernames && emails && RecordStatuss && flags) {
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

	public static boolean email(String email) {
		if (email.contains("@") && email.contains(".")) {
			return true;
		} else
			return false;
	}

	public static boolean RecordStatus(String recordstatus) {
		if (recordstatus.contains("N") || recordstatus.contains("M") || recordstatus.contains("D")
				|| recordstatus.contains("A") || recordstatus.contains("R")) {
			return true;
		} else
			return false;
	}

	public static boolean flag(String flag) {
		if (flag.contains("A") || flag.contains("I")) {
			return true;
		} else
			return false;
	}
}

