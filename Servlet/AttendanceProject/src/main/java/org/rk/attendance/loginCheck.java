package org.rk.attendance;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logincheck")
public class loginCheck extends HttpServlet
{
	String username;
	String password;
	String email;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
	
	 String un=req.getParameter("un");
	 String pwd=req.getParameter("pw");
	 String outQry="select * from worker_db.worker_data where username=? and password=?";
	 PrintWriter out=resp.getWriter();
	 try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt=con.prepareStatement(outQry);
			pstmt.setString(1,un );
			pstmt.setString(2,pwd);
			ResultSet rs=pstmt.executeQuery();
			
			
			
			if(rs.next())
			{
		       //RequestDispatcher rd=req.getRequestDispatcher("/login");
		      //rd.forward(req, resp);
				username=rs.getString(1);
				password=rs.getString(2);
				email=rs.getString(3);
				out.print("<html><body bgcolor='yellow'>"+"username:"+username+"<br>"+" "+"Password:"+
						password+"<br>"+"email: "+email+"</html></body>");
		    }
			else
			{
				 out.print("<html><body bgcolor='cyan'>"+"<h3>"
			    			+"</h3></body></html>");  
				 RequestDispatcher rd=req.getRequestDispatcher("/Register.html");
				 System.out.println("Include is done");
				 rd.include(req, resp);
			 }
			
	      }
	 catch (Exception e) 
	 {
		// TODO: handle exception
	 }
}
}
