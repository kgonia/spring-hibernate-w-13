<%--
  Created by IntelliJ IDEA.
  User: krzgo
  Date: 4/24/2022
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/person" method="post">
    <input name="login" placeholder="Podaj login">
    <input name="password" type="password" placeholder="Hasło">
    <input name="email" placeholder="email">
    <input type="submit" value="Wyślij">
</form>
</body>
</html>
