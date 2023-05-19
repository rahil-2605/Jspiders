package org.ty.app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/rahil")
public class Student extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name =req.getParameter("name");
		String password =req.getParameter("pw");
		
		PrintWriter output= resp.getWriter();
    	output.print("<html><body bgcolor='cyan'>"+"<h1>Details of emp:-"+name+" "+password+""
    			+"</h1></body></html>");
		
		
	}

}
