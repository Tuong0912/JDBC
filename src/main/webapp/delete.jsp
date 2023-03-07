<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/03/2023
  Time: 10:16 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/StudentServlet">Back to Students list</a></p>
<form method="post">
    <fieldset>
        <legend>Delete Student</legend>
        <table>
            <tr>
                <td>ID :</td>
                <td><input type="text" readonly value="${students.id()}"></td>
            </tr>            <tr>
                <td>Name :</td>
                <td><input type="text" readonly value="${students.name()}"></td>
            </tr>            <tr>
                <td>Point :</td>
                <td><input type="text" readonly value="${students.point()}"></td>
            </tr>            <tr>
                <td>Location :</td>
                <td><input type="text" readonly value="${students.location()}"></td>
            </tr>
            <tr>
                <td>Age :</td>
                <td><input type="text" readonly value="${students.age()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
