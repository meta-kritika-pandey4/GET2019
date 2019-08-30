package com.metacube.get2019;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class GetStoredStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		int student_id = Integer.parseInt(request.getParameter("student_id"));
		try{  
			DatabaseConnection jdbcObj = new DatabaseConnection();
			Connection con = jdbcObj.connect();
			Statement st = con.createStatement(); 
			ResultSet rs  = st.executeQuery(Queries.populateStudentQuery(student_id));
			rs.next();
			String first_name = rs.getString("first_name");
			System.out.println(first_name);
			String last_name = rs.getString("last_name");
			String father_name = rs.getString("father_name");
			int age = rs.getInt("age");
			String class_name = rs.getString("class");
			String email = rs.getString("email_id");
			
			// Page for updating the data in the database
			out.print("<!DOCTYPE html>"
						+ "<HTML> "
						+ "<HEAD> "
						+ "<TITLE>Add Student Details</TITLE>"
						+ "</HEAD> "
						+ "<BODY> "
						+ "<div align=center name='UpdateStudentForm'>"
						+ "<form action ='updateStudent' method = 'get'>"
						+ "<H1>Update Student Details</H1>"
						+ "<table cellspacing=10>"
						+ "<tr >"         
						+ "<td><label style=color:red>*</label><label >Student ID :</label></td>" 
						+ "<td><input  type=text name = 'student_id' required value = '"+student_id+"' readonly></td>"
						+ "</tr>"
						+ "<tr >"         
						+ "<td><label style=color:red>*</label><label >First Name :</label></td>" 
						+ "<td><input  type=text name = 'first_name' required value = '"+first_name+"'></td>"
						+ "</tr>"
						+ "<td id = 'first_name_validation' style=color:red colspan=2></td></tr>"
						+ "<tr >"        
						+ "<td><label style=color:red>*</label><label >Last Name :</label></td>" 
						+ "<td><input  type=text name = 'last_name' required value = '"+last_name+"'></td>"
						+ "</tr>"
						+ "<td id = 'last_name_validation' style=color:red colspan=2></td></tr>"
						+ "<tr >"
						+ "<td><label style=color:red>*</label><label >Father's Name :</label></td>"
						+ "<td><input  id = 'fnm' type=text name = 'father_name' required value = '"+father_name+"'></td>"
						+ "</tr>"
						+ "<td id = 'father_name_validation' style=color:red colspan=2></td></tr>"
						+ "<tr >"      
						+ "<td><label style=color:red>*</label><label >Age :</label></td>"
						+ "<td><input  type=number name = 'age' required value = '"+age+"'></td>"
						+ "</tr>"
						+ "<td id = 'age_validation' style=color:red colspan=2></td></tr>"
						+ "<tr>"
						+ "<td><label style=color:red>*</label><label >Class :</label></td>"
						+ "<td><input type='text' name = 'class' required value = '"+class_name+"'></td>"
						+ "</tr>"
						+ "<tr>"
						+ "<td><label style=color:red>*</label><label >Email name :</label></td>" 
						+ "<td><input type='text' name = 'email' required value = '"+email+"'></td>"
						+ "</tr>"
						+ "<td id = 'email_validation' style=color:red colspan=2></td></tr>"
						+ "</table>"
						+ "<br/>"
						+ "<input type = 'submit' value = 'Update' onclick=getFatherName()></a>"
						+ "</form> "
						+ "</div>"
						+ "</BODY>"
						+ "</HTML>");
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			out.close();
		}
	}
}
