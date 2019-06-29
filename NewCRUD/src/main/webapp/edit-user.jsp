
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User's edit</h1>

<form action="/update" method="post">
    <label>Id:<input type="text" name="id" value="${user.id}"></label><br>
    <label>Your Name:<input type="text" name="name" value="${user.name}"></label><br>
    <label>Your Login:<input type="text" name="login" value="${user.login}"></label><br>
    <label>Password:<input type="password" name="password" value="${user.password}"></label><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
