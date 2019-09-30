<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<HTML>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<HEAD>
<TITLE>Meta Parking</TITLE>
<STYLE>
a {
	margin-left: 50px;
	color: white;
	text-decoration: none;
}

input {
	border: 0;
}

#imageUpload {
	display: none;
}

#profileImage {
	cursor: pointer;
	float: left;
	margin-right: 20px;
	/* If you want to crop the image to a certain size, use something like this */
	object-fit: cover;
	width: 100px;
	height: 100px;
}
</STYLE>

</HEAD>


<BODY
	style='background-image: url("/images/parking1.jpg"); height: 100%; background-size: cover; background-repeat: no-repeat;'>

	<form:form method='get' action='EditYourProfile'
		modelAttribute="employeeDetails">
		<DIV ALIGN=CENTER
			style="background-color: midnightblue; width: 40%; height: 100%; color: white;">
			<NAV style="background-color: grey; height: 60px;">
				<BR /> <A href="/welcomePage/${email}">HOME</A> <A
					href="/getFriends/${email}">FRIENDS</A> <A href="/logout">LOGOUT</A>
			</NAV>
			<table cellspacing=15>
				<tr>
					<td colspan=2 style='font-size: 150%;'>${message}</td>
				</tr>
				<tr>
					<td colspan=2><image id="profileImage"
							src="/images/download.jpg"
							onclick="document.getElementById('imageUpload').click()" /> <input
						id="imageUpload" type="file" name="profile_photo"
						placeholder="Photo" required="" capture>
						</form></td>
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
			<br /> <input type='submit' value='Edit Profile'> <br /> <br />
			<input type='submit' value='Find Your Friends'
				formaction='getFriends/${email}'>
		</div>
	</form:form>

	<SCRIPT>document.getElementById("imageUpload").onchange = function() {
		  if (this.files && this.files[0]) {
			    var reader = new FileReader();
			    reader.onload = function(e) {
			      // e.target.result is a base64-encoded url that contains the image data
			      document.getElementById('profileImage').setAttribute('src', e.target.result);
			    };
			    reader.readAsDataURL(this.files[0]);
			  }
			}
	</SCRIPT>

</BODY>
</HTML>