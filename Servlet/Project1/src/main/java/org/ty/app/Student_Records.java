package org.ty.app;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class Student_Records extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		 String sid=req.getParameter("id");
		    int id =Integer.parseInt(sid); 
		    
	        String name =req.getParameter("nm");
	        String place=req.getParameter("pl");
	        
	        
			
			//System.out.println(name+" "+password);
			
	        PrintWriter output= res.getWriter();
	    	output.print("<html><body bgcolor='cyan'>"+"<h1>Details of emp:-"+id +" "+name+" "+place+""
	    			+"</h1></body></html>");
	    	
	    	String inqry="Insert into student.studentrecords values(?,?,?)";
	
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
				
				// prepared Statement Interface
				PreparedStatement pstmt =con.prepareStatement(inqry);
				
				//Set the data for placeholders
				pstmt.setInt(1, id);
				pstmt.setString(2,name);
				pstmt.setString(3, place);
				
				
				
				
				pstmt.executeUpdate();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
		       
			}

		
	}

}
