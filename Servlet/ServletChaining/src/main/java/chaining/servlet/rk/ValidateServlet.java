package chaining.servlet.rk;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/validate")
public class ValidateServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	   String id=req.getParameter("id");
	   
	   String pwd=req.getParameter("pw");
	   PrintWriter out=resp.getWriter();
	   
	   if(pwd.equals("root"))
	   {
		   RequestDispatcher rd=req.getRequestDispatcher("/welcome");
		   rd.forward(req, resp);
	   }
	   else
	   {
		   out.print("<html><body bgcolor='cyan'>"+"<h1>Sorry Username or Password is incorrect!!!"
	    			+"</h1></body></html>");
		   
		   RequestDispatcher rd=req.getRequestDispatcher("login.html");
		   rd.include(req, resp);
	   }
	   
	}

}
