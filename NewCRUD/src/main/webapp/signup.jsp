<%--
  Created by IntelliJ IDEA.
  User: Kancnelson
  Date: 04.07.2019
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Registration</h1>
<form action="/insert" method="post">
    <label>Your Name:<input type="text" name="name"></label><br>
    <label>Your Login:<input type="text" name="login"></label><br>
    <label>Password:<input type="password" name="password"></label><br>
    <input type="submit" value="Sign UP">
</form>
</body>
</html>
