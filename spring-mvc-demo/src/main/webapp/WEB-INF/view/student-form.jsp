<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Smart
  Date: 10.02.2023
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>

    <form:form action="processForm" modelAttribute="student">

        First name: <form:input path="firstName"/>
        <br>
        <br>

        Last name: <form:input path="lastName"/>
        <br>
        <br>
        
        <input type="submit" value="Submit"/>
        
    </form:form>


</body>
</html>