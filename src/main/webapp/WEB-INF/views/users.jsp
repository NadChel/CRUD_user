<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="j" uri="http://java.sun.com/jstl/core" %>--%>
<%--<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<html>
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

        <t:url var="updateButton" value="/updateUser">
            <t:param name="userId" value="${user.id}"/>
        </t:url>
        <t:url var="deleteButton" value="/deleteUser">
            <t:param name="userId" value="${user.id}"/>
        </t:url>
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
