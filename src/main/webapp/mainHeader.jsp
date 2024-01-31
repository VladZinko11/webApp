<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 28.12.2023
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/auth", method="get">
    <button class="header-button" type="submit">registration</button>
</form>
<form action="${pageContext.request.contextPath}/signIn", method="get">
    <button class="header-button" type="submit">sign in</button>
</form>
<form action="${pageContext.request.contextPath}/index", method="get">
    <button class="header-button" type="submit">main page</button>
</form>
</body>
</html>
