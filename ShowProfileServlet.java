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
 * Servlet implementation class ShowProfileServlet
 */
@WebServlet("/ShowProfileServlet")
public class ShowProfileServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try{  
			DatabaseConnection jdbcObj = new DatabaseConnection();
			Connection con = jdbcObj.connect();
			Statement st = con.createStatement();
			int employee_id=Integer.parseInt(request.getParameter("employee_id"));
			ResultSet rs = st.executeQuery(Queries.getEmployeeQuery(employee_id));
			if ( rs.next() ) {
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
                          +"<FORM method='get' action=''>"
                          +"<DIV ALIGN=CENTER style=background-color:midnightblue;width:40%;height:100%;color:white; >"
                          +"<br/><br/><br/>"
                          +"<table cellspacing=15>"
                          +"<tr >"          
                          +"<td colspan=2 style='font-size: 150%;'>"+full_name+"</td>"
                          +"</tr> "
                          + "<tr >"         
  						  + "<td><label>Employee ID :</label></td>" 
  						  + "<td name='employee_id'>"+employee_id+"</td>"
  						  + "</tr>"
  						  + "<tr >"         
  						  + "<td><label >Full Name :</label></td>" 
  						  + "<td name='full_name'>"+full_name+"</td>"
  						  + "</tr>"
  						  + "<tr >"        
  						  + "<td><label >Gender :</label></td>" 
  						  + "<td name='gender'>"+gender+"</td>"
  						  + "</tr>"
  						  + "<tr >"
  						  + "<td><label >Contact Number :</label></td>"
  						  + "<td name='contact'>"+contact+"</td>"
  						  + "</tr>"
  						  + "<tr >"      
  						  + "<td><label >Organization :</label></td>"
  						  + "<td name='organization'>"+organization+"</td>"
  						  + "</tr>"
  						  + "<tr>"
  						  + "<td><label >Vehicle Name :</label></td>"
  						  + "<td>"+vehicle_name+"</td>"
  						  + "</tr>"
  						  + "<tr>"
  						  + "<td><label >Vehicle Type :</label></td>" 
  						  + "<td>"+vehicle_type+"</td>"
  						  + "</tr>"
  						  + "<tr>"
						  + "<td><label >Vehicle Number :</label></td>" 
						  + "<td>"+vehicle_number+"</td>"
						  + "</tr>"
						  + "<tr>"
  						  + "<td><label >Identification :</label></td>" 
  						  + "<td>"+identification+"</td>"
  						  + "</tr>"
  						  + "<tr>"
  						  + "<td><label >Vehicle Price :</label></td>" 
						  + "<td>"+pass_price+"</td>"
						  + "</tr>"
  						  + "</table>"
  						  + "<br/>"
  						  + "<a href='index.html'><input type='button' value='Home'></a>"
  						  + "</form>"
  						  +"<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>"
  						  +"</div>"
  						  +"</BODY>"
  						  +"</HTML>");
				//RequestDispatcher rd=request.getRequestDispatcher("userProfileServlet");  
			    //rd.include(request, response);
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
