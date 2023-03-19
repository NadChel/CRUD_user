<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users Database</title>
    <link href='./users-style-sheet.css' rel='stylesheet'>
</head>
<body>
<h2>Users:</h2>
<table>
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Last name</th>
        <th scope="col">Age</th>
        <th scope="col">Email</th>
        <th scope="col">Operations</th>
    </tr>
    </thead>
    <tbody>
    <j:forEach var="user" items="${userList}">

        <j:url var="updateButton" value="/updateUser">
            <j:param name="userId" value="${user.id}"/>
        </j:url>
        <j:url var="deleteButton" value="/deleteUser">
            <j:param name="userId" value="${user.id}"/>
        </j:url>
        <tr>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td>${user.email}</td>
            <td>
                <input type="button" value="Update" onclick="window.location.href='${updateButton}'"/>
                <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </j:forEach>
    </tbody>
</table>
<input type="button" value="Add" onclick="window.location.href = '/add'"/>
</body>
</html>
