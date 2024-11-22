<%@ page import="models.User" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<h1>Welcome to your Dashboard, ${username}</h1>
<form action = "${pageContext.request.contextPath}/attendance" method = "GET">
    <input type="submit" value = "See Attendance">
</form>
</body>
</html>
