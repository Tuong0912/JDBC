<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/03/2023
  Time: 06:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/StudentServlet">Back to Students list</a></p>
<table>
    <tr>
        <td>Name :</td>
        <td>${students.name()}</td>
    </tr>
    <tr>
        <td>Point :</td>
        <td>${students.point()}</td>
    </tr>
    <tr>
        <td>Location :</td>
        <td>${students.location()}</td>
    </tr>
    <tr>
        <td>Age :</td>
        <td>${students.age()}</td>
    </tr>
</table>
</body>
</html>
