<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>User Info</title>
    <link rel="icon" href="/favicons/favicon.ico"/>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
    <link href="/stylesheets/users-style-sheet.css" rel="stylesheet">
</head>
<body>
<h2>Fill in the forms</h2>
<br>
<%--@elvariable id="user" type="app.models.User"--%>
<form:form action="saveUser" modelAttribute="user">
    <form:hidden path="id"/>
    Name: <form:input path="name"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Age: <form:input path="age"/>
    <br><br>
    Email: <form:input path="email"/>
    <br><br>
    <input class='main-button' type="submit" value="Submit">
</form:form>
</body>
</html>
