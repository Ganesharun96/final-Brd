package com.demo;
import reccords.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class maker extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
	    Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
//	    BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
//	    System.out.println(reader.readLine());
	    String selection = request.getParameter("selection");
	    try {
	    	if (selection.equals("recordlevel")) {
			Recordlevel.main(fileContent,fileName);
			System.out.println("hai");
	    	}
	    	
	    	else {
	    		Filelevel.main(fileContent,fileName);
	    		System.out.println("hai hello");
	    	}
//	    	else if (selection.equals("recordlevel"))
//			{
//	    		Fileuploaded1.mains(fileContent,fileName);
//			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
}
