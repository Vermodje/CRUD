<%@ page import="com.example.projects.user.User" %>
<%@ page import="com.example.projects.dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Вячеслав
  Date: 29.06.2019
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
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
    <%
        UserDao userDao = new UserDao();
        List<User>list = new ArrayList<>();
        list = userDao.getAllUsers();
        ListIterator<User> iterator = list.listIterator();

    %>
    <table border="1"  cellpadding="5">
        <caption style="font-size: 40px;">All Users</caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Password</th>
            <th>Login</th>
            <th>Actions</th>
        </tr>


        <%
            while (iterator.hasNext()){
                User user = iterator.next();
        %>
        <tr>
            <td style="text-align: center"><%=user.getId()%></td>
            <td style="text-align: center"><%=user.getName()%></td>
            <td style="text-align: center"><%=user.getPassword()%></td>
            <td style="text-align: center"><%=user.getLogin()%></td>
            <td>
                <a href="/edit?id=<%=user.getId()%>">Edit</a>
                <a href="/delete?id=<%=user.getId()%>">Delete</a>
            </td>
        </tr>
        <%
            }

        %>


    </table>
</div>
</body>

</html>
