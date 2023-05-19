package org.tyss.app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Facebook extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("pw");
		
		PrintWriter writer=new PrintWriter("D:\\html.txt");
		
		writer.write(name+" "+password);
		System.out.println("Done");
		
//		output.print("<html><body bgcolor='cyan'>"+"<h1>Details of emp:-"+name+" "+password+""
//    			+"</h1></body></html>");
		
		
		
	}

	
}
