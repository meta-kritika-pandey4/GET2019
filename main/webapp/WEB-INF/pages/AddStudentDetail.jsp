<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!-- Page for adding student details in the database -->

<!DOCTYPE html>
<HTML>
<!--Required meta tags-->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <HEAD>
        <TITLE>Add Student Details</TITLE>
        <SCRIPT src='fetching_data.js'></SCRIPT>
    </HEAD>
    <BODY>
        <div align=center name="StudentForm">
            <form:form action = "addStudentDetails" method = "POST" modelAttribute="studentCommands">
            <form:errors/>
                <H1>Add Student Details</H1>
                <table cellspacing=10>
                    <tr >          
                        <td><form:label  path = "firstName" style="color:red">*</form:label><form:label path = "firstName" >First Name :</form:label></td> 
                        <td><form:input path = "firstName" required="true"/></td>
                    </tr>
                    <tr><td colspan=2><form:errors path="firstName" style="color:red"/></td></tr>
                    <tr >          
                        <td><form:label  path = "lastName" style="color:red">*</form:label><form:label path = "lastName">Last Name :</form:label></td> 
                        <td><form:input path = "lastName" required="true"/></td>
                    </tr>
                    <tr><td colspan=2><form:errors path="lastName" style="color:red"/></td></tr>
                    <tr >          
                        <td><form:label  path = "fatherName" style="color:red">*</form:label ><form:label path = "fatherName" >Father's Name :</form:label></td> 
                        <td><form:input path = "fatherName" required="true"/></td>
                    </tr>
                    <tr><td colspan=2><form:errors path="fatherName" style="color:red"/></td></tr>
                    <tr >          
                        <td><form:label  path = "age" style="color:red">*</form:label><form:label path = "age" >Age :</form:label></td> 
                        <td><form:input  type="number" path = "age" required="true"/></td>
                    </tr>
                    <tr><td colspan=2><form:errors path="age" style="color:red"/></td></tr>
                    <tr>
                        <td><form:label  path = "className" style="color:red">*</form:label><form:label path = "className" >Class :</form:label></td> 
                        <td><form:input  path = "className" required="true"/></td>
                    </tr>
                    <tr><td colspan=2><form:errors path="className" style="color:red"/></td></tr>
                    <tr>
                        <td><form:label  path = "email" style="color:red">*</form:label><form:label path = "email">Email name :</form:label></td> 
                        <td><form:input path = "email" required="true"/></td>
                    </tr>
                    <tr><td colspan=2><form:errors path="email" style="color:red"/></td></tr>
                </table>
                <br/>
                <input type="submit" value="Submit" > 
            </form:form> 
        </div>
    </BODY>
</HTML>