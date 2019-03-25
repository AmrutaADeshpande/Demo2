package com.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		con=ConnectionManager.getConnection();
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String rollno = req.getParameter("roll");
		int roll = Integer.parseInt(rollno);
		pw.println("student info <br>");		
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from student where roll = ?");
			ps.setInt(1,roll);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
			  pw.print(rs.getInt(1)+" "+" "+rs.getString(2)+" "+rs.getInt(3));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}