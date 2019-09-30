<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE>Edit Employee Details</TITLE>
<STYLE>
a {
	margin-left: 50px;
	color: white;
	text-decoration: none;
}
</STYLE>
</HEAD>
<BODY
	style='background-image: url("/images/parking1.jpg"); height: 100%; background-size: cover; background-repeat: no-repeat;'>
	<DIV ALIGN=CENTER
		style="background-color: midnightblue; width: 40%; height: 100%; color: white;">
		<NAV style="background-color: grey; height: 60px;">
			<BR /> <A href="/welcomePage/${email}">HOME</A> <A
				href="/getFriends/${email}">FRIENDS</A> <A href="/logout">LOGOUT</A>
		</NAV>
		<form:form action='updateProfile' method='post'
			modelAttribute='employeeDetails'>
			<form:errors style='color:red' />
			<p style="color: white">${message}</p>
			<p style='font-size: 150%;'>Here's your current profile
				${employee.fullName}!</p>
			<table cellspacing=10>
				<tr>
					<td><label style="color: red">*</label><label>Employee
							ID :</label></td>
					<td><form:input path='employeeId' required='true'
							value='${employee.employeeId}' readonly='true' /></td>
				</tr>
				<tr>
					<td colspan=2><form:errors path="organization"
							style="color:red" /></td>
				</tr>
				<tr>
					<td><label style="color: red">*</label><label>Full
							Name :</label></td>
					<td><form:input path='fullName' required='true'
							value='${employee.fullName}' /></td>
				</tr>
				<tr>
					<td colspan=2><form:errors path="fullName" style="color:red" /></td>
				</tr>
				<tr>
				<tr>
					<td><label style="color: red">*</label><label>Gender
							:</label></td>
					<td><form:input path='gender' required='true'
							value='${employee.gender}' /></td>
				</tr>
				<tr>
					<td colspan=2><form:errors path="gender" style="color:red" /></td>
				</tr>
				<tr>
					<td id='last_name_validation' style="color: red" colspan=2></td>
				</tr>
				<tr>
					<td><label style="color: red">*</label><label>Contact
							:</label></td>
					<td><form:input id='fnm' path='contact' required='true'
							value="${employee.contact}" /></td>
				</tr>
				<tr>
					<td colspan=2><form:errors path="contact" style="color:red" /></td>
				</tr>
				<tr>
				<tr>
					<td><label style="color: red">*</label><label>Organization
							:</label></td>
					<td><form:select path='organization'>
							<option value='Metacube' id='Metacube'>Metacube</option>
							<option value='TCS' id='TCS'>TCS</option>
							<option value='Wipro' id='Wipro'>Wipro</option>
							<option value='Cognizant' id='Cognizant'>Cognizant</option>
							<option value='${employee.organization}' selected>${employee.organization}</option>
						</form:select></td>
				</tr>
				<tr>
					<td colspan=2><form:errors path="organization"
							style="color:red" /></td>
				</tr>
			</table>
			<br />
			<input type='submit' value='Update Profile'>
			<br />
			<br />
			<br />
			<br />
		</form:form>
	</div>
</BODY>
</HTML>