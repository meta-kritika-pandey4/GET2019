<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Page for adding student details in the database -->

<!DOCTYPE html>
<HTML>
<!--Required meta tags-->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<HEAD>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/studentStyleSheet.css " />
<TITLE>ADD STUDENT DETAILS</TITLE>
<SCRIPT src='fetching_data.js'></SCRIPT>
</HEAD>
<BODY>
	<div name="StudentForm">
		<form:form action="addStudentDetails" method="POST"
			modelAttribute="studentCommands">
			<form:errors />
			<div class="form-group">
				<H1>ADD STUDENT DETAILS</H1>
				<form:label path="firstName" style="color:red">*</form:label>
				<form:label path="firstName">First Name :</form:label>
				<br />
				<form:input class="form-control" path="firstName" required="true"
					placeholder="Enter your first name" />
				<br />
				<form:errors path="firstName" style="color:red" />
				<br />
				<form:label path="lastName" style="color:red">*</form:label>
				<form:label path="lastName">Last Name :</form:label>
				<br />
				<form:input class="form-control" path="lastName" required="true"
					placeholder="Enter your last name" />
				<br />
				<form:errors path="lastName" style="color:red" />
				<br />
				<form:label path="fatherName" style="color:red">*</form:label>
				<form:label path="fatherName">Father's Name :</form:label>
				<br />
				<form:input class="form-control" path="fatherName" required="true"
					placeholder="Enter your father's name" />
				<br />
				<form:errors path="fatherName" style="color:red" />
				<br />
				<form:label path="age" style="color:red">*</form:label>
				<form:label path="age">Age :</form:label>
				<br />
				<form:input type="number" path="age" class="form-control"
					required="true" placeholder="Enter your age" />
				<br />
				<form:errors path="age" style="color:red" />
				<br />
				<form:label path="className" style="color:red">*</form:label>
				<form:label path="className">Class :</form:label>
				<br />
				<form:input class="form-control" path="className" required="true"
					placeholder="Enter your class" />
				<br />
				<form:errors path="className" style="color:red" />
				<br />
				<form:label path="email" style="color:red">*</form:label>
				<form:label path="email">Email:</form:label>
				<br />
				<form:input class="form-control" path="email" required="true"
					placeholder="Enter your email address" />
				<br />
				<form:errors path="email" style="color:red" />
				<br /> <input type="submit" value="SUBMIT"
					class="btn btn-primary btn-lg"> <br />
			</div>
		</form:form>
	</div>
</BODY>
</HTML>