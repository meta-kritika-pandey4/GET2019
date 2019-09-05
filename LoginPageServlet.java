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
import javax.servlet.http.HttpSession;

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
			ResultSet rs1 = st.executeQuery(Queries.validateEmployeeQuery(email_id, password));
			if (!rs1.next() ) {
			    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
			    rd.include(request, response);
			    out.print("<div ALIGN=CENTER style='background-color:midnightblue;width:40%;height:100%;margin-top:-10em;color:white;'>The username or password is incorrect!</div>");  
			} else {
				HttpSession session=request.getSession();  
		        session.setAttribute("email_id",email_id);  
				ResultSet rs = st.executeQuery(Queries.searchEmployeeQuery(email_id, password));
				while(rs.next()){
				int employee_id=rs.getInt("employee_id");
				String full_name=rs.getString("full_name");
				String gender=rs.getString("gender");
				long contact=rs.getLong("contact");
				String organization=rs.getString("organization");
				String vehicle_name=rs.getString("vehicle_name");
				String vehicle_number=rs.getString("vehicle_number");
				String vehicle_type=rs.getString("vehicle_type");
				String identification=rs.getString("identification");
				float pass_price=rs.getFloat("price");
				out.print("<!DOCTYPE html>"
                          +"<HTML>"
                          +"<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                          +"<HEAD>"
                          +"<TITLE>Meta Parking</TITLE>"
                          +"</HEAD>"
                          +"<BODY style='background-image:url(parking1.jpg);"
                          +"height:100%;background-size:cover;background-repeat:no-repeat;'>"
                          +"<FORM method='get' action='editProfileServlet'>"
                          +"<DIV ALIGN=CENTER style=background-color:midnightblue;width:40%;height:100%;color:white; >"
                          +"<br/><br/><br/>"
                          + "<div align=RIGHT style='margin-right:2em;'><a href='logoutServlet'><input type='button' value='LogOut'></a></div>"
                          +"<table cellspacing=15>"
                          +"<tr >"
                          +"<td colspan=2 style='font-size: 150%;'>Hi "+full_name+" :)</td>"
                          +"</tr> "
                          + "<tr >"         
  						  + "<td><label value="+employee_id+" >Employee ID :</label></td>" 
  						  + "<td><input style='background-color:midnightblue;color:white;' type='text' readonly name='employee_id' value='"+employee_id+"'></td>"
  						  + "</tr>"
  						  + "<tr >"         
  						  + "<td><label >Full Name :</label></td>" 
  						  + "<td><input style='background-color:midnightblue;color:white;' type='text' readonly name='full_name' value='"+full_name+"'></td>"
  						  + "</tr>"
  						  + "<tr >"        
  						  + "<td><label >Gender :</label></td>" 
  						  + "<td><input style='background-color:midnightblue;color:white;' type='text' readonly name='gender' value='"+gender+"'></td>"
  						  + "</tr>"
  						  + "<tr >"
  						  + "<td><label >Contact Number :</label></td>"
  						  + "<td><input style='background-color:midnightblue;color:white;' type='text' readonly name='contact' value='"+contact+"'></td>"
  						  + "</tr>"
  						  + "<tr >"      
  						  + "<td><label >Organization :</label></td>"
  						  + "<td><input style='background-color:midnightblue;color:white;' type='text' readonly name='organization' value='"+organization+"'></td>"
  						  + "</tr>"
  						  + "<tr>"
  						  + "<td><label >Vehicle Name :</label></td>"
  						  + "<td><input style='background-color:midnightblue;color:white;' type='text' readonly name='vehicle_name' value='"+vehicle_name+"'></td>"
  						  + "</tr>"
  						  + "<tr>"
  						  + "<td><label >Vehicle Type :</label></td>" 
  						  + "<td><input style='background-color:midnightblue;color:white;' type='text' readonly value='"+vehicle_type+"'></td>"
  						  + "</tr>"
  						  + "<tr>"
						  + "<td><label >Vehicle Number :</label></td>" 
						  + "<td><input style='background-color:midnightblue;color:white;' type='text' readonly value='"+vehicle_number+"'></td>"
						  + "</tr>"
						  + "<tr>"
  						  + "<td><label >Identification :</label></td>" 
  						  + "<td><input style='background-color:midnightblue;color:white;' type='text' readonly value='"+identification+"'></td>"
  						  + "</tr>"
  						  + "<tr>"
						  + "<td><label >Vehicle Price :</label></td>" 
						  + "<td><input style='background-color:midnightblue;color:white;' type='text' readonly value='"+pass_price+"'></td>"
						  + "</tr>"
  						  + "</table>"
  						  + "<br/>"
  						  + "<input type = 'submit' value = 'Edit Profile' >"
  						  + "</br>"
  						  + "</br>"
  						  + "<input type='submit' value='Find Your Friends' formaction='getFriendsServlet'></a>"
  						  + "</form>"
  						  +"<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>"
  						  +"</div>"
  						  +"</BODY>"
  						  +"</HTML>");
				}
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
		
