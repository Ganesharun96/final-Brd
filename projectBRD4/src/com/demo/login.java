package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.operations.And;

import sun.security.action.GetIntegerAction;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/login")
public class login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String makerorchecker = request.getParameter("makerorchecker");
		

		 Boolean b=validateLogin(name, password, makerorchecker);
		
		if (validateLogin(name, password, makerorchecker)) {

			response.sendRedirect("Welcome.jsp");

		} else {
			
			response.sendRedirect("loginpage.html");
			
			
		}
			
	}

	private boolean validateLogin(String name, String password, String makerorchecker) {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			Statement statement = connection.createStatement();
		
			String query = "SELECT * FROM DBCONNECTIONS WHERE NAME ='" +name+ "' and PASSWORD = '" +password+ "' AND MAKERORCHECKER = '" +makerorchecker+ "'";

			ResultSet Result = statement.executeQuery(query);

			
			if (Result.next()) {

				return true;
			}

		} catch (ClassNotFoundException exception) {
			System.out.println(exception);
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return false;
	}
}