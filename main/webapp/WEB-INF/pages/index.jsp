<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- First page of the application-->
<html>
<head>
<meta charset="ISO-8859-1">
<title>StudentApplication</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/studentStyleSheet.css " />
</head>
<body align=center>
	<div>
		<form align='center'>
			<h1>STUDENT APPLICATION</h1>
			<h4>What do you want to do?</h4>
			<a href="AddStudentDetail"><input type=button
				class="btn btn-primary btn-lg" value='Add Student Details'></a><br />
			<br /> <a href="showStudent"><input type=button
				class="btn btn-primary btn-lg" value='Get Student List'></a><br />
			<br /> <a href="/searchStudent"><input type=button
				class="btn btn-primary btn-lg" value='Search Student'></a><br />
			<br />
		</form>
	</div>
</body>
</html>