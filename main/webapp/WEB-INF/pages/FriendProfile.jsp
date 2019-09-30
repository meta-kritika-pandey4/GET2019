<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<HTML>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<HEAD>
<TITLE>Meta Parking</TITLE>
<STYLE>
input {
	border: 0;
}

a {
	margin-left: 50px;
	color: white;
	text-decoration: none;
}
</STYLE>
</HEAD>
<BODY
	style='background-image: url("/images/parking1.jpg"); height: 100%; background-size: cover; background-repeat: no-repeat;'>
	<form:form method='post' modelAttribute="employeeDetails">
		<DIV ALIGN=CENTER
			style="background-color: midnightblue; width: 40%; height: 100%; color: white;">
			<NAV style="background-color: grey; height: 60px;">
				<BR /> <A href="/welcomePage/${email}">HOME</A> <A
					href="/getFriends/${email}">FRIENDS</A> <A href="/logout">LOGOUT</A>
			</NAV>

			<br /> <br /> <br />
			<table cellspacing=15>
				<tr>
					<td colspan=2 style='font-size: 150%;'>${message}</td>
				</tr>
				<tr>
					<td><label>Employee ID :</label></td>
					<td><form:input
							style='background-color: midnightblue; color: white;'
							readonly='true' path='employeeId' value='${employee.employeeId}' /></td>
				</tr>
				<tr>
					<td><label>Full Name :</label></td>
					<td><form:input
							style='background-color: midnightblue; color: white;'
							readonly='true' path='fullName' value='${employee.fullName}' /></td>
				</tr>
				<tr>
					<td><label>Gender :</label></td>
					<td><form:input
							style='background-color: midnightblue; color: white;'
							readonly='true' path='gender' value='${employee.gender}' /></td>
				</tr>
				<tr>
					<td><label>Contact Number :</label></td>
					<td><form:input
							style='background-color: midnightblue; color: white;'
							readonly='true' path='contact' value='${employee.contact}' /></td>
				</tr>
				<tr>
					<td><label>Organization :</label></td>
					<td><form:input
							style='background-color: midnightblue; color: white;'
							readonly='true' path='organization'
							value='${employee.organization}' /></td>
				</tr>
				<tr>
					<td><label>Vehicle Name :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly name='vehicle_name' value='${vehicle.vehicleName}'></td>
				</tr>
				<tr>
					<td><label>Vehicle Type :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly value='${vehicle.vehicleType}'></td>
				</tr>
				<tr>
					<td><label>Vehicle Number :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly value='${vehicle.vehicleNumber}'></td>
				</tr>
				<tr>
					<td><label>Identification :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly value='${vehicle.identification}'></td>
				</tr>
				<tr>
					<td><label>Vehicle Price :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly value='${pass.passPrice}'></td>
				</tr>
			</table>
			<br />
		</div>
	</form:form>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

</BODY>
</HTML>