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
<div class="forms-and-heading">
<h2>Fill in the forms</h2>
<%--@elvariable id="user" type="app.models.User"--%>
<form:form class="forms" action="saveUser" modelAttribute="user">
    <form:hidden path="id"/>
    <form:label path="name">Name: </form:label>
    <form:input path="name"/>
    <br><br>
    <form:label path="lastName">Last name: </form:label>
    <form:input path="lastName"/>
    <br><br>
    <form:label path="age">Age: </form:label>
    <form:input path="age"/>
    <br><br>
    <form:label path="email">Email: </form:label>
    <form:input path="email"/>
    <br><br>
    <input class='main-button' type="submit" value="Submit">
</form:form>
</div>
</body>
</html>
