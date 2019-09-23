<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<HTML>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<HEAD>
<TITLE>SignUP</TITLE>
<!-- The js files are attached-->
<SCRIPT src = "js/validation_form.js"></SCRIPT>
</HEAD>
<BODY style='background-image:url("/images/parking1.jpg");background-size:cover;background-repeat:no-repeat;'>

<!--Registration Form of the employees-->

<DIV ALIGN=CENTER style='background-color:midnightblue;width:40%;height:100%;overflow:auto;color:white' >
<form:form method='post' action='Registration' id="Form1" modelAttribute='signUpForm'>
<form:errors/>
<H1>Employee Registration Form</H1>

<table cellspacing=15 style='color:white'>
<tr>          
	<td><label style="color:red">*</label><label >Full Name :</label></td> 
	<td><form:input id = "fullName" path="fullName"/></td>
</tr>
 <tr><td colspan=2><form:errors path="fullName" style="color:red"/></td></tr>
<tr>
	<td><label style="color:red">*</label><label>Gender : </label></td>
	<td>
		<form:radiobutton path="gender" value="Male" id = "male"/>Male<br/>
		<form:radiobutton path="gender" value="Female" id = "female"/>Female
	</td>
</tr>
 <tr><td colspan=2><form:errors path="gender" style="color:red"/></td></tr>
<tr>
	<td><label style="color:red">*</label><label >Email id :</label></td> 
	<td><form:input  id = "email" path='email'/></td>
</tr>
<tr><td colspan=2><form:errors path="email" style="color:red"/></td></tr>
<tr>
	<td><label style="color:red">*</label><label>Password :</label></td> 
	<td><form:input type="password" id = "password" path="password"/></td>
</tr>
<tr><td colspan=2><form:errors path="password" style="color:red"/></td></tr>
<tr>
	<td><label style="color:red">*</label><label >Confirm Password :</label></td> 
	<td><form:input type="password" path="confirmPassword" name = "confirmPassword"/></td>
</tr>
<tr><td colspan=2><form:errors path="confirmPassword" style="color:red"/></td></tr>
<form:errors style="color:red"/>
<tr>
	<td><label style="color:red">*</label><label >Contact Number :</label></td> 
	<td><form:input id = "contact" path="contact"/></td>
</tr>
<tr><td colspan=2><form:errors path="contact" style="color:red"/></td></tr>
<tr>
	<td><label style="color:red">*</label><label>Organization :</label></td>
	<td>
		<form:select path="organization">
		<form:option value="Metacube" id="Metacube" selected="true">Metacube</form:option>
		<form:option value="TCS" id="TCS">TCS</form:option>
		<form:option value="Wipro" id="Wipro">Wipro</form:option>
		<form:option value="Cognizant" id="Cognizant">Cognizant</form:option>
		</form:select></td>
</tr>
<tr>
	<td align="center" colspan=2><input type="submit" value="Register" ><br>
	</table>
<br/>
</form:form> 
</div>
</BODY>
</HTML>


