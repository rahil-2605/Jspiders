package database.check.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Check_Data extends HttpServlet  
{
	 int idl;
	 String place;
     String name;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		// logic 

		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid) ;
		
		// JDBC CODE

		//String inQry="insert into student.studentrecords values(?,?,?)";
        String outQry = "select * from student.studentrecords where id=?";
       

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");

			PreparedStatement pstmt = con.prepareStatement(outQry);


			//pstmt.executeUpdate(inQry);

			System.out.println("Ho raha Hai");
			pstmt.setInt(1, id);
			
            ResultSet rs = pstmt.executeQuery(outQry);
            PrintWriter out = resp.getWriter();
            if(rs.next())
            {
            	idl=rs.getInt(1);
            	name=rs.getString(2);
            	place=rs.getString(3);
            	
            	out.print("<html><body bgcolor='orange'>"+idl
        				+ "</html></body>");
            	System.out.println(idl);
            }
            else
            {
            	out.print("<html><body bgcolor='orange'>"
        				+ "<h1> Id is not found"
        				+ " </h1></body></html>");
            }
            
            
          

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      

		
		

	
	}
}
