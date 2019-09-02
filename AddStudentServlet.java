package com.metacube.get2019;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * It is a servlet that is used to add student details into the 
 * database of the student application
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
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
			int rowsAdded = st.executeUpdate(Queries.addStudentQuery(first_name, last_name, father_name, age, class_name, email));
			out.println("</table><br/><br/>");
			out.println("<div align='center'  width=50% >"
					+ " <p>Student details added successfully!!Yayy</p>"
					+ "<a href = 'index.html'><input type = 'button' value = 'Home Page'></a></div>");
		} catch ( SQLIntegrityConstraintViolationException e ) {
			out.println("<div align='center'  width=50% >"
					+ "<p>This email id already exists!!</p>"
					+ "<a href = 'AddStudentDetail.html'><input type = 'button' value = 'Register again? Click here'></a></div>");
			e.printStackTrace();
		}
		catch ( Exception e2 ) {
			e2.printStackTrace();
		} finally {
			out.close();
		}  
	} 
}

