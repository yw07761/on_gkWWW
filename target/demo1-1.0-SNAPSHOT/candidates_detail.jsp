<%@ page import="java.util.List" %>
<%@ page import="com.example.demo1.models.Experience" %>
<%@ page import="com.example.demo1.models.Candidate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Candidate Detail</title>
    <style>
        <title>Candidate Detail</title>
        <style>
         body {
             font-family: Arial, sans-serif;
             background-color: #f7f7f7;
             text-align: center;
         }

        h1 {
            color: #333;
        }

        .experience-card {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin: 20px auto;
            padding: 20px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        }

        p {
            margin: 0;
        }
    </style>
</head>
<body>
<h1>Candidate Detail</h1>
<div class="experience-card">
    <%
        List<Experience> experiences = (List<Experience>) request.getAttribute("experiences");
        for (Experience experience : experiences) {
    %>
    <h3>Experience</h3>
    <p><strong>Company:</strong> <%= experience.getCompanyName() %></p>
    <p><strong>Role:</strong> <%= experience.getRole() %></p>
    <p><strong>From Date:</strong> <%= experience.getFromDate() %></p>
    <p><strong>To Date:</strong> <%= experience.getToDate() %></p>
    <p><strong>Work Description:</strong> <%= experience.getWorkDescription() %></p>
    <% } %>
</div>
</body>
</html>
