<%@ page import="java.util.List" %>
<%@ page import="com.example.demo1.models.Experience" %><%--
  Created by IntelliJ IDEA.
  User: HOANGANH
  Date: 10/26/2023
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidate detail</title>
</head>
<body>
    <%
        List<Experience> experiences = (List<Experience>) request.getAttribute("experiences");
        for(Experience experience: experiences) {
    %>
        <p><%= experience.toString() %> </p>
    <%}%>
</body>
</html>
