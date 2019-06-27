<%--
  Created by IntelliJ IDEA.
  User: Kancnelson
  Date: 27.06.2019
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add new user</h1>
<form action="/WEB-INF/insert-controller.jsp">
    <p>Your Name:<input type="text" name="name"></p>
    <p>Your Login:<input type="text" name="login"></p>
    <p>Password<input type="text" name="password"></p>
    <input type="submit" value="insert">
</form>
</body>
</html>
