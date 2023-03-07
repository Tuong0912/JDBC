<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/03/2023
  Time: 09:45 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/StudentServlet">Back to Students list</a>
</p>
<form  method="post">
    <fieldset>
        <legend>
            Edit Student
        </legend>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${students.name()}"></td>
            </tr>
            <tr>
                <td>Point</td>
                <td><input type="text" name="point" value="${students.point()}"></td>
            </tr>
            <tr>
                <td>Location</td>
                <td><input type="text" name="location" value="${students.location()}"></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="age" value="${students.age()}"></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
