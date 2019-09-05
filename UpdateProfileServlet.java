package com.metacube.get2019;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String full_name = request.getParameter("full_name");
		String gender = request.getParameter("gender");
		String contact = request.getParameter("contact");
		String organization = request.getParameter("organization");
		try{  
			DatabaseConnection jdbcObj = new DatabaseConnection();
			Connection con = jdbcObj.connect();
			Statement st = con.createStatement(); 
			int x  = st.executeUpdate(Queries.updateEmployeeQuery(employee_id,full_name,gender,contact,organization));
			out.println("<!DOCTYPE html>"
					+ "<HTML> "
					+ "<HEAD> "
					+ "<TITLE>Edit Employee Details</TITLE>"
					+ "</HEAD> "
					+ "<BODY style='background-image:url(parking1.jpg);"
					+ "height:100%;background-size:cover;background-repeat:no-repeat;'> "
					+ "<DIV ALIGN=CENTER style=background-color:midnightblue;width:40%;height:100%;color:white; >"
					+ "<p>Employee Details Updated!!</p>"
					+ "<a href = 'index.html'><input type = 'button' value = 'Home Page'></a></div></body></html>");
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			out.close();
		}	
	}
}
