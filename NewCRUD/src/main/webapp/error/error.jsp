<%--
  Created by IntelliJ IDEA.
  User: Kancnelson
  Date: 04.07.2019
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span style="color: red;"><%=request.getAttribute("error").toString()%></span><br>
<a href="/admin">Back</a>
</body>
</html>
