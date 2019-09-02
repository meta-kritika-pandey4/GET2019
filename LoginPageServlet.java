package com.metacube.get2019;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPageServlet
 */
@WebServlet("/LoginPageServlet")
public class LoginPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		String email_id = request.getParameter("home_email_id");  
		String password = request.getParameter("home_password"); 
		try{  
			DatabaseConnection jdbcObj = new DatabaseConnection();
			Connection con = jdbcObj.connect();
			Statement st = con.createStatement(); 
			ResultSet rs = st.executeQuery(Queries.searchEmployeeQuery(email_id, password));
			if (!rs.next() ) {
				
				 
			    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
			    rd.include(request, response);
			    out.print("<div ALIGN=CENTER style='background-color:midnightblue;width:40%;height:100%;margin-top:-10em;color:white;'>The username or password is incorrect!</div>");  
			}
			else
			{
				out.println("Hi "+email_id);
			}
		} catch ( SQLIntegrityConstraintViolationException e ) {
			e.printStackTrace();
		}
		catch ( Exception e2 ) {
			e2.printStackTrace();
		} finally {
			out.close();
		}  
	} 
}
		
