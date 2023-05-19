package com.Demo_Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;



public class test extends GenericServlet
{


	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
        String id=req.getParameter("id");
        String name =req.getParameter("name");
        String place=req.getParameter("place");
        
        
		
		//System.out.println(name+" "+password);
		
        PrintWriter output= res.getWriter();
    	output.print("<html><body bgcolor='cyan'>"+"<h1>Details of emp:-"+name+" "+place+""
    			+"</h1></body></html>");
	}
	

}

