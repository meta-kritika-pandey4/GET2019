<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<HTML>
<meta name='viewport' content'width=device-width, initial-scale=1.0'>
<HEAD>
<TITLE>MotorCyclePass</TITLE>
<SCRIPT src = 'js/javascript_file.js'></SCRIPT>
</HEAD>
<BODY style='background-image:url("/images/parking1.jpg");background-size:cover;background-repeat:no-repeat;'>
<DIV ALIGN=CENTER style='background-color:midnightblue;width:40%;height:100%;overflow:auto;color:white'>
<form:form method='Post' modelAttribute="pass" action="getPassDetails">
<br/>
<!--Motorcycle Pass Pricing Details-->
<h3>Motorcycle Pass Prices</h3>
<table cellspacing=10 style='color:white'>
 <% request.getAttribute("vehicleType");%>
 <tr><form:input type='hidden' value='${vehicleType}' path='vehicleType'/></tr>
<tr>
<td><label>Choose Currency :</label></td>
<td><form:select path="currencyType" onchange ='motorCycleCurrency()'>
<option value='INR' id='INR' selected>INR</option>
<option value='USD' id='USD'>USD</option>
<option value='YEN' id='YEN'>YEN</option>
</form:select></td>
</tr>
<tr>
<td><label>Daily :</label></td>
<td><form:radiobutton value='00.14' path="passPrice" name='pass' id = 'motorcycle_pass1'/><label id = 'mcp1'>10 INR</label><br/></td>
</tr>
<tr>
<td><label>Monthly :</label></td>
<td><form:radiobutton value='02.80' path="passPrice" name='pass' id = 'motorcycle_pass2'/><label id = 'mcp2'>200 INR</label><br/></td>
</tr>
<tr>
<td><label>Yearly :</label></td>
<td><form:radiobutton value='14.00' path="passPrice" name='pass' id = 'motorcycle_pass3'/><label id = 'mcp3'>1000 INR</label><br/></td>
</tr>
<tr><td colspan=2><form:errors path="passPrice" style="color:red"/></td></tr>
<tr><td colspan=2><form:errors path="currencyType" style="color:red"/></td></tr>
</table>
<br/>
<br/>
<input type = 'submit' value = 'Register?'>
<br/>
<br/>
</form:form>
</div>
</body>
</html>