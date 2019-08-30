package com.metacube.get2019;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowStudentServlet
 */
@WebServlet("/ShowStudentServlet")
public class ShowStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try{  
			DatabaseConnection jdbcObj = new DatabaseConnection();
			Connection con = jdbcObj.connect();
			Statement st = con.createStatement(); 
			
			//dynamic page for showing all the students present in the database
			out.println("<div align= 'center'>");
			out.println("<h3>Student Details</h3>");
			ResultSet rs  = st.executeQuery(Queries.showStudentQuery());
			out.println("<table border='1' cellspacing=5>");
			out.println("<tr><th>S.No</th><th>First Name</th><th>Last Name</th><th>Father's Name</th><th>Age</th><th>Class</th><th>Email</th></tr>");
			while ( rs.next() ) {
				String student_id = rs.getString("student_id");
				System.out.println(student_id);
				out.print("<tr>");
				out.print("<td>"+rs.getString("student_id")+"</td>");
				out.print("<td>"+rs.getString("first_name")+"</td>");
				out.print("<td>"+rs.getString("last_name")+"</td>");
				out.print("<td>"+rs.getString("father_name")+"</td>");
				out.print("<td>"+rs.getInt("age")+"</td>");
				out.print("<td>"+rs.getString("class")+"</td>");
				out.print("<td>"+rs.getString("email_id")+"</td>");
				out.print("<td><a href='getStoredStudent?student_id=" + student_id + "'><input type = 'button' value = 'Update'></a></td>");
				out.print("</tr>");
			}
			out.println("</table><br/><br/>");
			out.println("<div align='center'  width=50% >"
					+ "<a href = 'index.html'><input type = 'button' value = 'Home Page'></a></div>");
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			out.close();
		}
	}
	
}
