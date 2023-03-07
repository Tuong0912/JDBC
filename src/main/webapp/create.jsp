<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02/03/2023
  Time: 06:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/StudentServlet">Back to Students list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Create Students</legend>
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" readonly></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Point</td>
                <td><input type="text" name="point"></td>
            </tr>
            <tr>
                <td>Location</td>
                <td><input type="text" name="location"></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Create"></td>
            </tr>
        </table>

    </fieldset>
</form>
</body>
</html>
