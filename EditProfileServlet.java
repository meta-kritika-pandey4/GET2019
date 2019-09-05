package com.metacube.get2019;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
			String full_name = request.getParameter("full_name");
			String gender = request.getParameter("gender");
			String contact = request.getParameter("contact");
			String organization = request.getParameter("organization");
			
			// Page for updating the data in the database
			out.print("<!DOCTYPE html>"
						+ "<HTML> "
						+ "<HEAD> "
						+ "<TITLE>Edit Employee Details</TITLE>"
						+ "</HEAD> "
						+ "<BODY style='background-image:url(parking1.jpg);"
						+"height:100%;background-size:cover;background-repeat:no-repeat;'> "
						+"<DIV ALIGN=CENTER style=background-color:midnightblue;width:40%;height:100%;color:white; >"
						+ "<form action ='updateProfileServlet' method = 'get'>"
						+ "<p style='font-size: 150%;'>Here's your current profile "+full_name+"!</p>"
						+ "<table cellspacing=10>"
						+ "<tr >"         
						+ "<td><label style=color:red>*</label><label >Employee ID :</label></td>" 
						+ "<td><input  type=text name = 'employee_id' required value = '"+employee_id+"' readonly></td>"
						+ "</tr>"
						+ "<tr >"         
						+ "<td><label style=color:red>*</label><label >Full Name :</label></td>" 
						+ "<td><input  type=text name = 'full_name' required value = '"+full_name+"'></td>"
						+ "</tr>"
						+ "<td id = 'first_name_validation' style=color:red colspan=2></td></tr>"
						+ "<tr >"        
						+ "<td><label style=color:red>*</label><label >Gender :</label></td>" 
						+ "<td><input  type=text name = 'gender' required value = '"+gender+"'></td>"
						+ "</tr>"
						+ "<td id = 'last_name_validation' style=color:red colspan=2></td></tr>"
						+ "<tr >"
						+ "<td><label style=color:red>*</label><label >Contact :</label></td>"
						+ "<td><input  id = 'fnm' type=text name = 'contact' required value = "+contact+"></td>"
						+ "</tr>"
						+ "<td id = 'father_name_validation' style=color:red colspan=2></td></tr>"
						+ "<tr >"      
						+ "<td><label style=color:red>*</label><label >Organization :</label></td>"
						+ "<td><select name='organization'>"
						+"<option value='Metacube' id='Metacube' >Metacube</option>"
						+"<option value='TCS' id='TCS'>TCS</option>"
						+"<option value='Wipro' id='Wipro'>Wipro</option>"
						+"<option value='Cognizant' id='Cognizant'>Cognizant</option>"
						+"<option selected>--select--</option>"
						+"</select></td></td>"
						+ "</tr>"
						+ "</table>"
						+ "<br/>"
						+ "<input type = 'submit' value = 'Update Profile'></a>"
						+ "</form> "
						+ "</div>"
						+ "</BODY>"
						+ "</HTML>");
	}
}

	


