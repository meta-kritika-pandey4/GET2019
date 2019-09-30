<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Search student form -->
<!DOCTYPE html>
<html>
<head>
<STYLE>
a {
	margin-left: 50px;
	color: white;
	text-decoration: none;
}
</STYLE>
<meta charset="ISO-8859-1">
<title>Search Friends</title>
</head>
<BODY
	style='background-image: url("/images/parking1.jpg"); background-size: cover; background-repeat: no-repeat;'>
	<DIV ALIGN=CENTER
		style='background-color: midnightblue; width: 40%; height: 100%; overflow: auto; color: white'>
		<NAV style="background-color: grey; height: 60px;">
			<BR /> <A href="/welcomePage/${email}">HOME</A> <A
				href="/getFriends/${email}">FRIENDS</A> <A href="/logout">LOGOUT</A>
		</NAV>
		<p>${message}</p>
		<c:if test="${fn:length(friendsList) gt 0}">
			<table cellspacing=20>
				<tr>
					<th>EMPLOYEE ID</th>
					<th>FULL NAME</th>
					<th></th>
				</tr>
				</thead>
				<c:forEach items="${friendsList}" var="friend">
					<tr>

						<td>${friend.employeeId}</td>
						<td>${friend.fullName}</td>
						<td><a style="color: white;"
							href="<c:url value='/ViewProfile/${friend.email}'/>">View
								Profile</a></td>
					</tr>
					</thead>
				</c:forEach>
			</table>
		</c:if>
	</DIV>

</body>
</html>
