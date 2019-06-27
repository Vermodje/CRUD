<%@ page import="executor.Executor" %><%--
  Created by IntelliJ IDEA.
  User: Kancnelson
  Date: 27.06.2019
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String login = request.getParameter("login");
    Executor executor = new Executor();
    executor.execUpdate(name, password, login);

%>
<script>
    window.location.href = "http://localhost:8081/insert";
</script>
</body>
</html>
