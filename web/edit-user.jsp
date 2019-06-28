
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User's edit</h1>

<form action="/insert" method="post">
    <p>Your Name:<input type="text" name="name" value="${user.name}"></p>
    <p>Your Login:<input type="text" name="login" value="${user.login}"></p>
    <p>Password<input type="password" name="password" value="${user.password}"></p>
    <input type="submit" value="Insert">
</form>
</body>
</html>
