<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Update Student Form -->
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
<TITLE>UPDATE STUDENT DETAILS</TITLE>
<style>
</style>
</HEAD>
<BODY>
	<div class="studentDiv">
		<form:form method="post" modelAttribute="updateStudentCommands">
			<form:errors />
			<div class="form-group">
				<H1>UPDATE STUDENT DETAILS</H1>
				<label style="color: red">*</label><label>Student Id :</label><br />
				<input class="form-control" required value="${student.studentId}"
					readonly /><br />
				<form:label path="firstName" style="color:red">*</form:label>
				<form:label path="firstName">First Name :</form:label>
				<br />
				<form:input class="form-control" path="firstName" required="true"
					value="${student.firstName}" />
				<br />
				<form:errors path="firstName" style="color:red" />
				<br />
				<form:label path="lastName" style="color:red">*</form:label>
				<form:label path="lastName">Last Name :</form:label>
				<br />
				<form:input class="form-control" path="lastName" required="true"
					value="${student.lastName}" />
				<br />
				<form:errors path="lastName" style="color:red" />
				<br />
				<form:label path="fatherName" style="color:red">*</form:label>
				<form:label path="fatherName">Father's Name :</form:label>
				<br />
				<form:input class="form-control" path="fatherName" required="true"
					value="${student.fatherName}" />
				<br />
				<form:errors path="fatherName" style="color:red" />
				<br />
				<form:label path="age" style="color:red">*</form:label>
				<form:label path="age">Age :</form:label>
				<br />
				<form:input type="number" path="age" class="form-control"
					required="true" value="${student.age}" />
				<br />
				<form:errors path="age" style="color:red" />
				<br />
				<form:label path="className" style="color:red">*</form:label>
				<form:label path="className">Class :</form:label>
				<br />
				<form:input class="form-control" path="className" required="true"
					value="${student.className }" />
				<br />
				<form:errors path="className" style="color:red" />
				<br />
				<form:label path="email" style="color:red">*</form:label>
				<form:label path="email">Email:</form:label>
				<br />
				<form:input class="form-control" path="email" required="true"
					value="${student.email }" />
				<br />
				<form:errors path="email" style="color:red" />
				<br /> <input type="submit" value="UPDATE"
					class="btn btn-primary btn-lg"> <br />
			</div>
		</form:form>
	</div>

</BODY>

</HTML>