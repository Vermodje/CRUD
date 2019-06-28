<%@ page import="dao.UserDao" %>
<%@ page import="user.User" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Kancnelson
  Date: 26.06.2019
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body><h1>Add new user</h1>
  <form action="/insert" method="post">
    <p>Your Name:<input type="text" name="name"></p>
    <p>Your Login:<input type="text" name="login"></p>
    <p>Password<input type="password" name="password"></p>
    <input type="submit" value="Insert">
  </form>
  <a href="/list">All Users</a>
  <div class="container">
    <%
      UserDao userDao = new UserDao();
      List<User> list = userDao.getAllUsers();
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
          <a href="/">Delete</a>
        </td>
      </tr>
      <%
        }

      %>


    </table>
  </div>
  </body>
</html>
