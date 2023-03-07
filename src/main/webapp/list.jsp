<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/03/2023
  Time: 05:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/StudentServlet?action=create">Create new Student</a></p>

<form action="/StudentServlet?action=find" method="post">
    <table>
        <tr>
            <td><input type="text" name="id">Search Student</td>
            <td><input type="submit" value="Sreach"></td>
        </tr>
    </table>
</form>


<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Point</td>
        <td>Location</td>
        <td>Age</td>
    </tr>

    <c:forEach items="${students}" var="std">
        <tr>
            <td><a href="/StudentServlet?action=view">${std.id()}</a></td>
            <td>${std.name()}</td>
            <td>${std.point()}</td>
            <td>${std.location()}</td>
            <td>${std.age()}</td>
            <td><a href="/StudentServlet?action=edit&id=${std.id()}">Edit</a></td>
            <td><a href="/StudentServlet?action=delete&id=${std.id()}">Delete</a></td>
        </tr>
    </c:forEach>

    <tr>

    </tr>
</table>
</body>
</html>
