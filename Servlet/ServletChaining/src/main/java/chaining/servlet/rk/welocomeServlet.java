package chaining.servlet.rk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class welocomeServlet extends HttpServlet
{


	int id1;
	String name;
	String place;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String sid=req.getParameter("id");
		String pwd=req.getParameter("pw");
		//logic
		int id=Integer.parseInt(sid);
		//jdbc code
		String outQry="select * from student.studentrecords where id=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt=con.prepareStatement(outQry);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			PrintWriter out=resp.getWriter();
			
			
			if(rs.next())
			{
				id1=rs.getInt(1);
				name=rs.getString(2);
				place=rs.getString(3);
				out.print("<html><body bgcolor='yellow'>"+id1+""+name+" "+place+"</html></body>");
				
			}
			else 
			{
				out.print("<html><body bgcolor='yellow'><h1>Id not found</h1></html></body>");
			}	
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//PrintWriter out=resp.getWriter();
		 
		//out.print("<html><body bgcolor='cyan'>"+"<h1>Details of emp:-"+id+" "+pwd+""
    			//+"</h1></body></html>");				
	}
}

