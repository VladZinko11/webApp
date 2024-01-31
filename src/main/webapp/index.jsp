<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="mainHeader.jsp"%>
<html>
<link rel="stylesheet" href="css/stylesheet.css">
<body>


<%
    if(request.getAttribute("message")!=null)
        out.println("<h1 class = \" message \">" + request.getAttribute("message") + "</h1>");
%>
</body>
</html>
