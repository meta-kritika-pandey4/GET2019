<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<HTML>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<HEAD>
<TITLE>Meta Parking</TITLE>
</HEAD>
<BODY style='background-image: url(parking1.jpg); height: 100%; background-size: cover; background-repeat: no-repeat;'>
	<FORM method='get' action='editProfileServlet'>
		<DIV ALIGN=CENTER style="background-color: midnightblue; width: 40%; height: 100%; color: white;">
			<br />
			<br />
			<br />
			<div align=RIGHT style='margin-right: 2em;'>
				<a href='logoutServlet'><input type='button' value='LogOut'></a>
			</div>
			<table cellspacing=15>
				<tr>
					<td colspan=2 style='font-size: 150%;'>Hi "+full_name+" :)</td>
				</tr>
				<tr>
					<td><label value="+employee_id+">Employee ID :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly name='employee_id' value='"+employee_id+"'></td>
				</tr>
				<tr>
					<td><label>Full Name :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly name='full_name' value='"+full_name+"'></td>
				</tr>
				<tr>
					<td><label>Gender :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly name='gender' value='"+gender+"'></td>
				</tr>
				<tr>
					<td><label>Contact Number :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly name='contact' value='"+contact+"'></td>
				</tr>
				<tr>
					<td><label>Organization :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly name='organization' value='"+organization+"'></td>
				</tr>
				<tr>
					<td><label>Vehicle Name :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly name='vehicle_name' value='"+vehicle_name+"'></td>
				</tr>
				<tr>
					<td><label>Vehicle Type :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly value='"+vehicle_type+"'></td>
				</tr>
				<tr>
					<td><label>Vehicle Number :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly value='"+vehicle_number+"'></td>
				</tr>
				<tr>
					<td><label>Identification :</label></td>"
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly value='"+identification+"'></td>
				</tr>
				<tr>
					<td><label>Vehicle Price :</label></td>
					<td><input
						style='background-color: midnightblue; color: white;' type='text'
						readonly value='"+pass_price+"'></td>
				</tr>
			</table>
			<br /> <input type='submit' value='Edit Profile'> </br> </br> <input
				type='submit' value='Find Your Friends'
				formaction='getFriendsServlet'></a>
	</form>
	"
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
	</div>
</BODY>
</HTML>