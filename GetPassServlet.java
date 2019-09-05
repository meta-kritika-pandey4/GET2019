package com.metacube.get2019;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetMotorCycleServlet
 */
@WebServlet("/GetMotorCycleServlet")
public class GetPassServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();  
		String vehicle_number = request.getParameter("vehicle_number");
		int employee_id = Integer.parseInt(request.getParameter("employ_id"));
		String vehicle_type=request.getParameter("vehicleType");
		vehicle_type=vehicle_type.toLowerCase();
		request.setAttribute("employee_id", employee_id);
		request.setAttribute("vehicle_number", vehicle_number);
		switch(vehicle_type) {
		case "cycle":
			out.println("<!DOCTYPE html>"
						+"<html>"
						+"<head>"
						+"<meta charset='ISO-8859-1'>"
						+"<title>Insert title here</title>"
						+"<!-- The js files are attached-->"
						+"<SCRIPT src = 'javascript_file.js'></SCRIPT>"
						+"<SCRIPT src = 'validation_form.js'></SCRIPT>"
						+"</head>"
						+"<BODY style='background-image:url(parking1.jpg);background-size:cover;background-repeat:no-repeat;'>"
						+"<!--Cycle Pass Pricing Details-->"
						+"<DIV ALIGN=CENTER style='background-color:midnightblue;width:40%;height:100%;overflow:auto;color:white '>"
						+"<form action='getPassPriceServlet' method='get'>"
						+"<br/>"
						+"<h3>Cycle Pass Prices</h3>"
						+"<table cellspacing=15 style='color:white;'>"
						+"<tr>"
						+"<td><label>Choose Currency :</label></td>"
						+"<td><select name='currency' onchange = 'cycleCurrency()' >"
                        +"<option value='INR' id='INR' selected>INR</option>"
                        +"<option value='USD' id='USD'>USD</option>"
                        +"<option value='YEN' id='YEN'>YEN</option>"
                        +"</select></td>"
                        +"</tr>"
                        +"<tr>"
                        +"<td><label>Daily :</label></td>"
                        +"<td><input type='radio' value='00.07' name='pass' id = 'cycle_pass1'><label id = 'cp1'>5 INR</label><br/></td>"
                        +"</tr>"
                        +"<tr>"
                        +"<td><label>Monthly :</label></td>"
                        +"<td><input type='radio' value='01.40' name='pass' id = 'cycle_pass2'><label id = 'cp2'>100 INR</label><br/></td>"
                        +"</tr>"
                        +"<tr>"
                        +"<td><label>Yearly :</label></td>"
                        +"<td><input type='radio' value='07.00' name='pass' id = 'cycle_pass3'><label id = 'cp3'>500 INR</label><br/></td>"
                        +"</tr>"
                        +"<tr>"
                        +"<td collspan=2 id='vehicle_price_message' style='color:red'></td>"
                        +"</tr>"
                        +"<tr>"
                        +"<td><input type='hidden' name='vehicle_number' value='"+vehicle_number+"'></td>"
                        +"<td><input type='hidden' name='employee_id' value='"+employee_id+"'></td>"
                        +"</tr>"
                        +"</table>"
                        +"<br/>"
                    	+"<input type = 'button' value = 'Get Pass' onclick = getCyclePassPrice(getCurrency())>"+"<br/>"+"<br/>"
                    	+"<input type = 'submit' value = 'Register?'>"
                        +"<br/>"
                        +"<br/>"
                        +"</form>"
                        +"</div>"
                        +"</body>"
                        +"</html>");
			break;
		case "motorcycle":
			out.println("<!DOCTYPE html>"
					 	+"<HTML>"
						+"<meta name='viewport' content'width=device-width, initial-scale=1.0'>"
					    +"<HEAD>"
						+"<TITLE>MotorCyclePass</TITLE>"
						+"<SCRIPT src = 'javascript_file.js'></SCRIPT>"
						+"<SCRIPT src = 'validation_form.js'></SCRIPT>"
						+"</HEAD>"
						+"<BODY style='background-image:url(parking1.jpg);background-size:cover;background-repeat:no-repeat;'>"
						+"<DIV ALIGN=CENTER style='background-color:midnightblue;width:40%;height:100%;overflow:auto;color:white'>"
						+"<form action='getPassPriceServlet' method='get'>"
						+"<br/>"
						+"<!--Motorcycle Pass Pricing Details-->"
						+"<h3>Motorcycle Pass Prices</h3>"
						+"<table cellspacing=10 style='color:white'>"
						+"<tr>"
						+"<td><label>Choose Currency :</label></td>"
						+"<td><select onchange ='motorCycleCurrency()'>"
						+"<option value='INR' id='INR' selected>INR</option>"
						+"<option value='USD' id='USD'>USD</option>"
						+"<option value='YEN' id='YEN'>YEN</option>"
						+"</select></td>"
                        +"</tr>"
                        +"<tr>"
                        +"<td><label>Daily :</label></td>"
                        +"<td><input type='radio' value='00.14' name='pass' id = 'motorcycle_pass1'><label id = 'mcp1'>10 INR</label><br/></td>"
                        +"</tr>"
                        +"<tr>"
                        +"<td><label>Monthly :</label></td>"
                        +"<td><input type='radio' value='02.80' name='pass' id = 'motorcycle_pass2'><label id = 'mcp2'>200 INR</label><br/></td>"
                        +"</tr>"
                        +"<tr>"
                        +"<td><label>Yearly :</label></td>"
                        +"<td><input type='radio' value='14.00' name='pass' id = 'motorcycle_pass3'><label id = 'mcp3'>1000 INR</label><br/></td>"
                        +"</tr>"
                        +"<tr>"
                        +"<td collspan=2 id='vehicle_price_message' style='color:red'></td>"
                        +"</tr>"
                        +"<tr>"
                        +"<td><input type='hidden' name='vehicle_number' value='"+vehicle_number+"'></td>"
                        +"<td><input type='hidden' name='employee_id' value='"+employee_id+"'></td>"
                        +"</tr>"
						+"</table>"
						+"<br/>"
						+"<br/>"
						+"<input type = 'button' value = 'Get Pass' onclick = getMotorCyclePassPrice(getCurrency())>"+"<br/>"	+"<br/>"
	                	+"<input type = 'submit' value = 'Register?'>"
						+"<br/>"
						+"<br/>"
						+"</form>"
						+"</div>"
						+"</body>"
						+"</html>");
			break;
		case "fourwheeler":
			out.println(" <!DOCTYPE html>"
					+"<html>"
					+"<head>"
					+"<meta charset='ISO-8859-1'>"
					+"<title>Insert title here</title>"
					+"<!-- The js files are attached-->"
					+"<SCRIPT src = 'javascript_file.js'></SCRIPT>"
					+"<SCRIPT src = 'validation_form.js'></SCRIPT>"
					+"</head>"
					+"<BODY style='background-image:url(parking1.jpg);background-size:cover;background-repeat:no-repeat;'>"
					+"<!--Four Wheeler Pass Pricing Details-->"
					+"<DIV ALIGN=CENTER style='background-color:midnightblue;width:40%;height:100%;overflow:auto;color:white' >"
					+"<form action='getPassPriceServlet' method='get'>"
					+"<br/>"
					+"<h3>Four Wheeler Pass Prices</h3>"
					+"<table cellspacing=15 style='color:white'>"
					+"<tr>"
                    +"<td><label>Choose Currency :</label></td>"
                    +"<td><select onchange = 'fourwheelerCurrency()' >"
                    +"<option value='INR' id='INR' selected>INR</option>"
                    +" <option value='USD' id='USD'>USD</option>"
                    +"<option value='YEN' id='YEN'>YEN</option>"
                    +"</select></td>"
                    +"</tr>"
                    +"<tr>"
                    +"<td><label>Daily :</label></td>"
                    +"<td><input type='radio' value='00.28' name='pass' id = 'fourwheeler_pass1'><label id = 'fwp1'>20 INR</label><br/></td>"
                    +" </tr>"
                    +"<tr>"
                    +"<td><label>Monthly :</label></td>"
                    +"<td><input type='radio' value='07.00' name='pass' id = 'fourwheeler_pass2'><label id = 'fwp2'>500 INR</label><br/></td>"
                    +"</tr>"
                   +" <tr>"
                    +"<td><label>Yearly :</label></td>"
                    +"<td><input type='radio' value='49.00' name='pass' id = 'fourwheeler_pass3'><label id = 'fwp3'>3500 INR</label><br/></td>"
                    +" </tr>"
                    +"<tr>"
                	+"<td collspan=2 id='vehicle_price_message' style='color:red'></td>"
                	+"</tr>"
                	+"<tr>"
                    +"<td><input type='hidden' name='vehicle_number' value='"+vehicle_number+"'></td>"
                    +"<td><input type='hidden' name='employee_id' value='"+employee_id+"'></td>"
                    +"</tr>"
                	+"</table>"
                	+"<br/>"
                	+"<input type = 'button' value = 'Get Pass' onclick = getFourWheelerPassPrice(getCurrency())>"+"<br/>"	+"<br/>"
                	+"<input type = 'submit' value = 'Register?'>"
                	+"<br/>"
                	+"<br/>"
                	+"</form>"
                	+"</div> "
                	+"</body>"
                	+"</html> ");
			break;
		}
	}
}
