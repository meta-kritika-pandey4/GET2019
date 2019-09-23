<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Search student form -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/studentStyleSheet.css " />
<title>Search Student</title>
</head>
<body>
	<div class="studentDiv">
		<form:form action="/searchByName" method="POST"
			modelAttribute="searchByName">
			<form:errors />
			<H1>SEARCH STUDENT</H1>
			<div class="searchTable" style="padding: 2px;">
				<p>${message}</p>
				<c:if test="${fn:length(studentList) gt 0}">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">STUDENT ID</th>
								<th scope="col">FIRST NAME</th>
								<th scope="col">LAST NAME</th>
								<th scope="col">FATHER'S NAME</th>
								<th scope="col">EMAIL ID</th>
								<th scope="col">CLASS</th>
								<th scope="col">AGE</th>
							</tr>
						</thead>
						<c:forEach items="${studentList}" var="student">
							<thead class="thead-light">
								<tr>
									<td>${student.studentId}</td>
									<td>${student.firstName}</td>
									<td>${student.lastName}</td>
									<td>${student.fatherName }</td>
									<td>${student.email}</td>
									<td>${student.className}</td>
									<td>${student.age}</td>
								</tr>
							</thead>
						</c:forEach>
					</table>
				</c:if>
			</div>
			<div class="form-group" style="margin-top: 2px;">
				<form:label path="firstName" style="color:red">*</form:label>
				<form:label path="firstName">First Name :</form:label>
				<br />
				<form:input class="form-control" path="firstName" required="true"
					placeholder="Enter first name" />
				<br />
				<form:errors path="firstName" style="color:red" />
				<br />
				<form:label path="lastName" style="color:red">*</form:label>
				<form:label path="lastName">Last Name :</form:label>
				<br />
				<form:input class="form-control" path="lastName" required="true"
					placeholder="Enter last name" />
				<br />
				<form:errors path="lastName" style="color:red" />
				<br /> <input type="submit" value="SEARCH BY NAME"
					class="btn btn-primary btn-lg"> <br />
			</div>
		</form:form>
		<div class="searchTableByClass">
			<p>${messageForClassSearch}</p>
			<c:if test="${fn:length(studentListByClass) gt 0}">

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">STUDENT ID</th>
							<th scope="col">FIRST NAME</th>
							<th scope="col">LAST NAME</th>
							<th scope="col">FATHER'S NAME</th>
							<th scope="col">EMAIL ID</th>
							<th scope="col">CLASS</th>
							<th scope="col">AGE</th>
						</tr>
					</thead>
					<c:forEach items="${studentListByClass}" var="student">
						<thead class="thead-light">
							<tr>
								<td>${student.studentId}</td>
								<td>${student.firstName}</td>
								<td>${student.lastName}</td>
								<td>${student.fatherName }</td>
								<td>${student.email}</td>
								<td>${student.className}</td>
								<td>${student.age}</td>
							</tr>
						</thead>
					</c:forEach>
				</table>
			</c:if>
		</div>
		<form:form action="/searchByClass" method="POST"
			modelAttribute="searchByClass">
			<form:errors />
			<div class="form-group"
				style="margin-top: 0px; padding: 0px 45px 45px 45px;">
				<form:label path="className" style="color:red">*</form:label>
				<form:label path="className">Class :</form:label>
				<br />
				<form:input class="form-control" path="className" required="true"
					placeholder="Enter class" />
				<br />
				<form:errors path="className" style="color:red" />
				<br /> <input type="submit" value="SEARCH BY CLASS"
					class="btn btn-primary btn-lg"> <br /> <br /> <br /> <a
					href="/home"><input type=button class="btn btn-primary btn-lg"
					value="HOME PAGE"></a>
			</div>
		</form:form>
	</div>

</body>
</html>