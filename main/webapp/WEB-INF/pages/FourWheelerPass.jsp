<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset='ISO-8859-1'>
<title>FourWheerlerPass</title>
<!-- The js files are attached-->
<SCRIPT src='js/javascript_file.js'></SCRIPT>
</head>
<BODY style='background-image:url("/images/parking1.jpg"); background-size: cover; background-repeat: no-repeat;'>
<!--Four Wheeler Pass Pricing Details-->
<DIV ALIGN=CENTER style='background-color: midnightblue; width: 40%; height: 100%; overflow: auto; color: white'>
<form:form action="getPassDetails" method='Post' modelAttribute="pass">
<form:errors/>
<br/>
<h3>Four Wheeler Pass Prices</h3>
<table cellspacing=15 style='color: white'>
<tr>
<td><label>Choose Currency :</label></td>
<td><form:select path="currencyType" onchange='fourwheelerCurrency()'>
<option value='INR' id='INR' selected>INR</option>
<option value='USD' id='USD'>USD</option>
<option value='YEN' id='YEN'>YEN</option>
</form:select></td>
</tr>
 <tr><form:input type='hidden' value='${vehicleNumber}' path='vehicleNumber'/></tr>
 <tr><form:input type='hidden' value='${employeeId}' path='employeeId'/></tr>
  <tr><form:input type='hidden' value='${vehicleType}' path='vehicleType'/></tr>
<tr>
<td><label>Daily :</label></td>
<td><form:radiobutton value='00.28' path="passPrice" id='fourwheeler_pass1'/><label id='fwp1'>20 INR</label><br /></td>
</tr>
<tr>
<td><label>Monthly :</label></td>
<td><form:radiobutton value='07.00' path="passPrice" id='fourwheeler_pass2'/><label id='fwp2'>500 INR</label><br /></td>
</tr>
<tr>
<td><label>Yearly :</label></td>
<td><form:radiobutton value='49.00' path="passPrice" id='fourwheeler_pass3'/><label id='fwp3'>3500 INR</label><br /></td>
</tr>
<tr><td colspan=2><form:errors path="passPrice" style="color:red"/></td></tr>
<tr><td colspan=2><form:errors path="currencyType" style="color:red"/></td></tr>
</table>
<br/> 
<br/> 
<input type='submit' value='Register'><br/><br/>
</form:form>
</div>
</body>
</html>
