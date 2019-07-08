<%@ page import="com.example.projects.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.projects.service.UserService" %>
<%@ page import="com.example.projects.service.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Вячеслав
  Date: 29.06.2019
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body><h1>Add user</h1>
<form action="/insert" method="post">
    <label>Your Name:<input type="text" name="name"></label><br>
    <label>Your Login:<input type="text" name="login"></label><br>
    <label>Password:<input type="password" name="password"></label><br>
    <input type="submit" value="Insert">
</form>
<div class="container">

    <table border="1"  cellpadding="5">
        <caption style="font-size: 40px;">All Users</caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Password</th>
            <th>Login</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="user" items="${users}">
        <tr>
            <td style="text-align: center"><c:out value="${user.id}"></c:out> </td>
            <td style="text-align: center"><c:out value="${user.name}"></c:out></td>
            <td style="text-align: center"><c:out value="${user.password}"></c:out></td>
            <td style="text-align: center"><c:out value="${user.login}"></c:out></td>
            <td style="text-align: center"><c:out value="${user.role}"></c:out></td>
            <td>
                <a href="/edit?id=<c:out value="${user.id}"></c:out>">Edit</a>
                <a href="/delete?id=<c:out value="${user.id}"></c:out>">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>
