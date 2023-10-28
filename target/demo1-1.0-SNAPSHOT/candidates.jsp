<%@ page import="java.util.List" %>
<%@ page import="com.example.demo1.models.Candidate" %>
<%@ page import="com.example.demo1.repository.CandidateRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidates</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            text-align: center;
        }

        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
<%
    CandidateRepository candidateRepository = new CandidateRepository();
    List<Candidate> candidates = candidateRepository.getAll();
%>
<table>
    <tr>
        <th>id</th>
        <th>email</th>
        <th>full name</th>
        <th>phone</th>
        <th>detail</th>
    </tr>
    <% for (Candidate candidate: candidates) { %>
    <tr>
        <td><%=candidate.getId()%></td>
        <td><%=candidate.getEmail()%></td>
        <td><%=candidate.getFullName()%></td>
        <td><%=candidate.getPhone()%></td>
        <td><a href="cau4?can_id=<%=candidate.getId()%>">view detail</a></td>
    </tr>
    <%}%>
</table>
</body>
</html>
