<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VehicleRegistration</title>
<!-- The js files are attached-->
<SCRIPT src = "js/javascript_file.js"></SCRIPT>
</head>
<BODY style='background-image:url("/images/parking1.jpg");height:100%;background-size:cover;background-repeat:no-repeat;'>
 
 <!--Registration Form of the vehicles-->

<DIV ALIGN=CENTER style="background-color:midnightblue;width:40%;height:100%;overflow:auto;color:white" id="Form2">
<form:form action='VehicleRegistrationForm' method='post' modelAttribute="vehicleForm" >
<form:errors/>
<H1>Vehicle Registration Form</H1>
<table cellspacing=20 style="color:white">
<tr >          
<td><label style="color:red">*</label><label>Vehicle Name :</label></td> 
<td><form:input  id = "vehicleName" path="vehicleName"/></td>
</tr>
<tr><td colspan=2><form:errors path="vehicleName" style="color:red"/></td></tr>
<tr>
<td><label style="color:red">*</label><label>Vehicle Type : </label></td>
<td>
<form:radiobutton id="Cycle" path="vehicleType" value="Cycle"/>Cycle<br/>
<form:radiobutton id="MotorCycle" path="vehicleType" value="MotorCycle"/>Motorcycle<br/>
<form:radiobutton id="FourWheelers" path="vehicleType" value="FourWheeler"/>FourWheelers<br/>
</td>
</tr>
<tr><td colspan=2><form:errors path="vehicleType" style="color:red"/></td></tr>
<tr>
<td><label style="color:red">*</label><label>Vehicle Number :</label></td> 
<td><form:input type="text" id = "vehicle_number" path="vehicleNumber" /></td>
</tr>
<tr><td colspan=2 id="vehicle_number_message" style="color:red"></td>
</tr>
<tr><td colspan=2><form:errors path="vehicleNumber" style="color:red"/></td></tr>
<tr >          
<td><label style="color:red">*</label><label>Employee ID :</label></td> 
<td><form:input id = "employ_id" path="employeeId"/></td>
</tr>
<tr><td colspan=2><form:errors path="employeeId" style="color:red"/></td></tr>
<tr>
<td><label>Identification :</label></td> 
<td><form:input type="text" id = "vehicle_identification" path="Identification"/></td>
</tr>
<tr>
</tr>
</table>
<br/>
<input type="submit" value="Register" >
<br/>
<br/>
<br/>
<br/>
</form:form>    
</div>
</body>
</html>