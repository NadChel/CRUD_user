<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<!DOCTYPE html>
<html>
<body>
<h2>Fill in the forms</h2>
<br>
<%--@elvariable id="user" type="app.models.User"--%>
<form:form action="saveUser" modelAttribute="user">
    <form:hidden path="id"/>
    Name: <form:input path="name"/>
    <br>
    Last name: <form:input path="lastName"/>
    <br>
    Age: <form:input path="age"/>
    <br>
    Email: <form:input path="email"/>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
