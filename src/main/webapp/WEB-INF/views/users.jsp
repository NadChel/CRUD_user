<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<body>
<h2>Users:</h2>
<table>
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Last name</th>
        <th scope="col">Age</th>
        <th scope="col">Email</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach var="user" items="${userList}">
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td>${user.email}</td>
        </c:forEach>
    </tr>
    </tbody>
</table>
</body>
</html>
