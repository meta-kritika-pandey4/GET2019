<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  Show Students form -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Students</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/studentStyleSheet.css " />
</head>
<body>
	<div>
		<p>${message}</p>
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
					<th></th>
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
						<td><a
							href="<c:url value='/updateStudent/${student.studentId}' />">Edit</a></td>
					</tr>
				</thead>
			</c:forEach>
		</table>
		<a href="/home"><input type=button class="btn btn-primary btn-lg"
			value="HOME PAGE"></a>
	</div>
</body>
</html>