package com.metacube.get2019;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPassServlet
 */
@WebServlet("/GetPassServlet")
public class GetPassPriceServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();  
		String vehicle_number = request.getParameter("vehicle_number");
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		float price = Float.parseFloat(request.getParameter("pass"));
		try{  
				DatabaseConnection jdbcObj = new DatabaseConnection();
				Connection con = jdbcObj.connect();
				Statement st = con.createStatement();
				st.executeUpdate(Queries.addPassQuery(vehicle_number,price,employee_id));
				out.print("<!DOCTYPE html>"
						+"<html>"
						+"<head>"
						+"<meta charset='ISO-8859-1'>"
						+"<title>Insert title here</title>"
						+"</head>"
						+"<BODY style='background-image:url(parking1.jpg);background-size:cover;background-repeat:no-repeat;'>"
						+"<!--Cycle Pass Pricing Details-->"
						+"<DIV ALIGN=CENTER style='background-color:midnightblue;width:40%;height:100%;overflow:auto;color:white '>"
                        +"<p>Thank you!You have been successfully registered :)</p>"
                        +"<a href = 'index.html'><input type = 'button' value = 'Home Page'></a>"
                        +"</div></form></body>"
                        +"</html>");
		} catch ( SQLIntegrityConstraintViolationException e ) {
			out.print("<!DOCTYPE html>"
					+"<html>"
					+"<head>"
					+"<meta charset='ISO-8859-1'>"
					+"<title>Insert title here</title>"
					+"</head>"
					+"<BODY style='background-image:url(parking1.jpg);background-size:cover;background-repeat:no-repeat;'>"
					+"<!--Cycle Pass Pricing Details-->"
					+"<DIV ALIGN=CENTER style='background-color:midnightblue;width:40%;height:100%;overflow:auto;color:white '>"
                    +"<p>Sorry!Something went Wrong :(</p>"
                    +"<a href = 'index.html'><input type = 'button' value = 'Home Page'></a>"
                    +"</div></form></body>"
                    +"</html>");
			e.printStackTrace();
		}
		catch ( Exception e2 ) {
			e2.printStackTrace();
		} finally {
			out.close();
		}  
	} 
}
