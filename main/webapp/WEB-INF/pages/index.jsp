<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<HTML>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<HEAD>
<TITLE>Meta Parking</TITLE>
</HEAD>
<BODY style='background-image:url("/images/parking1.jpg");height:100%;background-size:cover;background-repeat:no-repeat;'>
<form:form method='post' modelAttribute="loginForm">
<form:errors/>
<div ALIGN=CENTER style=background-color:midnightblue;width:40%;height:100% ">
<br/><br/><br/>
<h2 STYLE=COLOR:WHITE>Welcome To Meta Parking!!</h2><br/><br/>
<h3 STYLE=COLOR:WHITE>ALREADY HAVE AN ACCOUNT?</h3><br/>
<table cellspacing=15>
<tr >          
<td><label style=color:red>*</label><label style=color:white>Email Id :</label></td> 
<td><form:input  type=text id = "home_email_id" path="email" required/></td>
</tr>
<tr >          
<td><label style=color:red>*</label><label style=color:white>Password :</label></td> 
<td><form:input  type=password id = "home_password" path = "password" required/></td>
</tr>
<tr>
<td colspan=2><input type='submit' value='LOGIN' style="background-color:slategrey;font-family:Verdana, Geneva, Tahoma, sans-serif; color:whitesmoke;width:100%"></td>
</tr>
</table>
<table>
<tr>
<td colspan=2><a href='SignUp'><input type='button' value='NEW TO META PARKING? SIGN UP!' style="background-color:slategrey;font-family:Verdana, Geneva, Tahoma, sans-serif; color:whitesmoke;width:100%"></a></td>
</tr>
</table>
</div>
</form:form>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</BODY>
</HTML>