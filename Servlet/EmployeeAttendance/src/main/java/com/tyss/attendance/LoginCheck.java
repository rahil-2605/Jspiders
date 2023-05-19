package com.tyss.attendance;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logincheck")
public class LoginCheck extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String empId=req.getParameter("empid");
		int id=Integer.parseInt(empId);
		
		String password=req.getParameter("password");
		
		PrintWriter out=resp.getWriter();
		String outQry=("select * from employeeinfo.employee where emp_id=? and password=?");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			
			PreparedStatement pstmt=con.prepareStatement(outQry);
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			
			ResultSet rs=pstmt.executeQuery();
			
			System.out.println("Step 1");
			
			if (rs.next()) {
				
			out.print("<html><body><h1>Its working</h1></body></html>");
			System.out.println("Its working");
				
			}
			else {
				out.print("<html><body><h1>Its not working</h1></body></html>");
				System.out.println("Its not working");
			}
		} catch (SQLException | ClassNotFoundException e) {
			
			
		}
		

	}

}