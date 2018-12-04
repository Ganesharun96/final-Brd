package reccords;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class database {
//	private static final String  = null;
static Connection connection = null;
static {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	}
	catch (ClassNotFoundException exception) {
		System.out.println(exception);
	} catch (SQLException exception) {
		System.out.println(exception);
	}
}
	public static void customer(String Customer_ID, String Customer_Code,String Customer_Name,String Customer_Address1,String Customer_Address2,String Customer_PinCode,String Email_Address,String Contact_Number,String Primary_Contact ,String Record_Status,String Active_Inactive_Flag,String Create_Date,String Created_By,String Modified_Date,String Modified_By,String Authorized_Date,String Authorized_By ) throws ClassNotFoundException {
		try {

			PreparedStatement preparedStatement=connection.prepareStatement("insert into GANESH values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1,  Customer_ID);
			preparedStatement.setString(2,  Customer_Code);
			preparedStatement.setString(3,  Customer_Name);
			preparedStatement.setString(4,  Customer_Address1);
			preparedStatement.setString(5,  Customer_Address2);
			preparedStatement.setString(6,  Customer_PinCode);
			preparedStatement.setString(7,  Email_Address);
			preparedStatement.setString(8,  Contact_Number);
			preparedStatement.setString(9,  Primary_Contact);
			preparedStatement.setString(10,  Record_Status);
			preparedStatement.setString(11,  Active_Inactive_Flag);
			preparedStatement.setString(12,  Create_Date);
			preparedStatement.setString(13,  Created_By);
			preparedStatement.setString(14,  Modified_Date);
			preparedStatement.setString(15,  Modified_By);
			preparedStatement.setString(16,  Authorized_Date);
			preparedStatement.setString(17,  Authorized_By);
			
			
			//Execute a Query
//			String insertQuery = "insert into GANESH_CUSTOMER_NAME(" + employeeID + ",'" + firstName + "')";
//			//System.out.println(insertQuery);
//			int noOfRowsAffected = statement.executeUpdate(insertQuery);
//			//Iterate through the result set and display the records.
//			System.out.println(noOfRowsAffected + " row(s) inserted!");
			
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	}

}

