<%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 27.12.2023
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="auth", method="post", action="${pageContext.request.contextPath}/auth">
        <p>
            <b>Логи:</b><br>
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
