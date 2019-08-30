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
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/updateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		int student_id = Integer.valueOf(request.getParameter("student_id"));
		String first_name = request.getParameter("first_name");  
		String last_name = request.getParameter("last_name"); 
		String father_name = request.getParameter("father_name");  
		int age = Integer.valueOf(request.getParameter("age"));
		String class_name = request.getParameter("class");
		String email = request.getParameter("email");  
		try{  
			DatabaseConnection jdbcObj = new DatabaseConnection();
			Connection con = jdbcObj.connect();
			Statement st = con.createStatement(); 
			int x  = st.executeUpdate(Queries.updateStudentQuery(student_id,first_name,last_name,father_name,email,age,class_name));
			out.println("<div align='center'  width=50% >"
					+ "<p>Student Details Updated!!</p>"
					+ "<a href = 'index.html'><input type = 'button' value = 'Home Page'></a></div>");
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			out.close();
		}
	}

	
}
