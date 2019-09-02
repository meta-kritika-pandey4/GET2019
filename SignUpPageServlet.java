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
 * Servlet implementation class SignUpPageServlet
 */
@SuppressWarnings("serial")
@WebServlet("/SignUpPageServlet")
public class SignUpPageServlet extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");  
			PrintWriter out = response.getWriter();  
			String isValid=request.getParameter("isValid");
			if(isValid.equals("true"))
			{
				String full_name=request.getParameter("full_name");
				String gender=request.getParameter("gender");
				long contact=Long.parseLong(request.getParameter("contact"));
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				String organization=request.getParameter("organization");
				int employee_id;
				
				try{  
					DatabaseConnection jdbcObj = new DatabaseConnection();
					Connection con = jdbcObj.connect();
					Statement st = con.createStatement();
					int rowsAffected=st.executeUpdate(Queries.addEmployeeQuery(full_name,gender,contact,email,password,organization));
					ResultSet rs1= st.executeQuery(Queries.getEmployeeId());
					if(rs1.next())
					{
						employee_id=rs1.getInt("curr_emp_id");
					}
					
					RequestDispatcher rd=request.getRequestDispatcher("VehicleRegistrationForm.html");  
				    rd.include(request, response);
			} catch ( SQLIntegrityConstraintViolationException e ) {
				RequestDispatcher rd=request.getRequestDispatcher("SignUpPage.html");  
			    rd.include(request, response);
			    out.println("This email id already exists!");
				e.printStackTrace();
			}
			catch ( Exception e2 ) {
				e2.printStackTrace();
			} finally {
				out.close();
			}  
		} 
			
					
	}
}
