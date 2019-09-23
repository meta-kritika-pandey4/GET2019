<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
    <head>
        <title> Spring Boot MVC Security </title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	  <link rel="stylesheet" href="/css/studentStyleSheet.css " />
    </head>
    <body>
        <h3> Spring Boot MVC Security</h3> 
        <form  method="POST"  >
            User Name : <input type="text"/> <br/><br/>
            Password: <input type="password" /> <br/><br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html> 