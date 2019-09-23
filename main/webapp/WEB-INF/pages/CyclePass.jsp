<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset='ISO-8859-1'>
<title>CyclePass</title>
<!-- The js files are attached-->
<SCRIPT src = 'js/javascript_file.js'></SCRIPT>
</head>
<BODY style='background-image:url("/images/parking1.jpg");background-size:cover;background-repeat:no-repeat;'>"
<!--Cycle Pass Pricing Details-->
<DIV ALIGN=CENTER style='background-color:midnightblue;width:40%;height:100%;overflow:auto;color:white '>
<form:form action='getPassDetails' method='post' modelAttribute="pass" >
<form:errors/>
<br/>
<h3>Cycle Pass Prices</h3>
<table cellspacing=15 style='color:white;'>
 <tr><form:input type='hidden' value='${vehicleNumber}' path='vehicleNumber'/></tr>
 <tr><form:input type='hidden' value='${employeeId}' path='employeeId'/></tr>
 <tr><form:input type='hidden' value='${vehicleType}' path='vehicleType'/></tr>
<tr>
<td><label>Choose Currency :</label></td>
<td><form:select path="currencyType" name='currency' onchange = 'cycleCurrency()' >
<option value='INR' id='INR' selected>INR</option>
<option value='USD' id='USD'>USD</option>
<option value='YEN' id='YEN'>YEN</option>
 </form:select></td>
</tr>
<tr>
<td><label>Daily :</label></td>
<td><form:radiobutton value='00.07' path="passPrice" id = 'cycle_pass1'/><label id = 'cp1'>5 INR</label><br/></td>
</tr>
<tr>
<td><label>Monthly :</label></td>
<td><form:radiobutton value='00.14' path="passPrice" id = 'cycle_pass2'/><label id = 'cp2'>100 INR</label><br/></td>
</tr>
<tr>
<td><label>Yearly :</label></td>
<td><form:radiobutton value='07.00' path="passPrice" id = 'cycle_pass3'/><label id = 'cp3'>500 INR</label><br/></td>
</tr>
<tr><td colspan=2><form:errors path="passPrice" style="color:red"/></td></tr>
<tr>
</tr>
<tr><td colspan=2><form:errors path="currencyType" style="color:red"/></td></tr>
</table>
<input type = 'submit' value = 'Register'><br/><br/>
<br/>
<br/>
</form:form>
</div>
</body>                        
</html>