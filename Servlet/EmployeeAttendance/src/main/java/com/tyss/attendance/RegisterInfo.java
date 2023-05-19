package com.tyss.attendance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerinfo")
public class RegisterInfo extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empId=req.getParameter("empid");
		int id=Integer.parseInt(empId);
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		
		String inqry="Insert into employeeinfo.employee values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt=con.prepareStatement(inqry);
			
			pstmt.setInt(1, id);		
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			
			pstmt.executeUpdate();
			System.out.println("Data Saved");
		} catch (SQLException | ClassNotFoundException e) {
			
		}
		if (empId!=null) {
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
		}	
	}
}
