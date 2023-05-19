package org.rk.attendance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String phoneNo=req.getParameter("number");
		String username = req.getParameter("un");
		String password = req.getParameter("pw");
		String email = req.getParameter("email");

		// logic 
		// int no=Integer.parseInt(phoneNo);
		// jdbc code
		String inqry = "Insert into worker_db.worker_data values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1 done");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Step 2 done");

			PreparedStatement pstmt = con.prepareStatement(inqry);

			// pstmt.setInt(1, no);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);

			System.out.println("Step 3 done");
			pstmt.executeUpdate();
			System.out.println("Step 4 done");

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (username != null) {
			RequestDispatcher rd = req.getRequestDispatcher("/LoginPage.html");
			rd.forward(req, resp);
		}
	}
}