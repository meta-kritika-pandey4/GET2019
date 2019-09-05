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
 * Servlet implementation class GetFriendsServlet
 */
@WebServlet("/GetFriendsServlet")
public class GetFriendsServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try{  
			DatabaseConnection jdbcObj = new DatabaseConnection();
			Connection con = (Connection) jdbcObj.connect();
			Statement st = (Statement) con.createStatement(); 
			int employee_id=Integer.parseInt(request.getParameter("employee_id"));
			//dynamic page for showing all the students present in the database
			ResultSet rs  = st.executeQuery(Queries.showFriendsQuery(employee_id));
			out.print("<!DOCTYPE html>"
                    +"<HTML>"
                    +"<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                    +"<HEAD>"
                    +"<TITLE>Meta Parking</TITLE>"
                    +"</HEAD>"
                    +"<BODY style='background-image:url(parking1.jpg);"
                    +"height:100%;background-size:cover;background-repeat:no-repeat;'>"
                    +"<DIV ALIGN=CENTER style=background-color:midnightblue;width:40%;height:100%;color:white;overflow:auto;' >"
                    + "<form method='get' action='showProfileServlet'>"
                    +"<br/>"
                    + "<p style='font-size: 150%;'>Meet your Friends!!</p><br/>"
                    +"<table  cellspacing=25 style='color:white;'>"
        			+"<tr><th>S.No</th><th>Friend Name</th><th>Employee ID</th><th></th>");
			int serial_no=1;			
			while ( rs.next() ) {
			int friend_employee_id = rs.getInt("employee_id");
			out.println("<tr>"
                        +"<td>"+(serial_no++)+"</td>"
                        +"<td>"+rs.getString("full_name")+"</td>"
                        +"<td><input style='background-color:midnightblue;color:white;' type='text' readonly name='employee_id' value="
                        + friend_employee_id+"></td>"
                        +"<td><input type = 'submit' value = 'Show Profile'></td>"
						+"</tr>");
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

	


