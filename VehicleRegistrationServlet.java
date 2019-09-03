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
 * Servlet implementation class VehicleRegistrationServlet
 */
@WebServlet("/VehicleRegistrationServlet")
public class VehicleRegistrationServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();  
			String vehicle_name=request.getParameter("vehicle_name");
			String vehicle_type=request.getParameter("vehicleType");
			String identification=request.getParameter("vehicle_identification");
			String vehicle_number = request.getParameter("vehicle_number");
			int employee_id = Integer.parseInt(request.getParameter("employ_id"));
			try{  
				DatabaseConnection jdbcObj = new DatabaseConnection();
				Connection con = jdbcObj.connect();
				Statement st = con.createStatement();
				
				st.executeUpdate(Queries.addVehicleQuery(vehicle_name,vehicle_type,identification,vehicle_number,employee_id));
				vehicle_type=vehicle_type.toLowerCase();
				switch(vehicle_type) {
				case "cycle":
					response.sendRedirect("CyclePass.html");
					break;
				case "motorcycle":
					response.sendRedirect("MotorCyclePass.html");
					break;
				case "fourwheeler":
					response.sendRedirect("FourWheelerPass.html");
					break;
				}
				
				
		} catch ( SQLIntegrityConstraintViolationException e ) {
			RequestDispatcher rd=request.getRequestDispatcher("VehicleRegistrationForm.html");  
		    rd.include(request, response);
		    out.println("<div align=center style='color:white;font-size:15px;'>This vehicle already exists!</div>");
			e.printStackTrace();
		}
		catch ( Exception e2 ) {
			e2.printStackTrace();
		} finally {
			out.close();
		}  
	} 
		
				
}
	

