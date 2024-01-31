<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 03.01.2024
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="signIn", method="post", action="${pageContext.request.contextPath}/signIn">
    <p>
        <b>Логин:</b><br>
        <input type="text", name="name">
    </p>
    <p>
        <b>Пароль:</b><br>
        <input type="text", name="password">
    </p>
    <input type="submit" value="Отправить">
    <input type="reset" value="Очистить"></p>

</form>
<%
    if(request.getAttribute("message")!=null)
        out.println("<h1>" + request.getAttribute("message") + "</h1>");
%>
</body>
</html>
