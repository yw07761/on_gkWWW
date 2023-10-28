<%@ page import="java.util.List" %>
<%@ page import="com.example.demo1.models.Candidate" %>
<%@ page import="com.example.demo1.repository.CandidateRepository" %><%--
  Created by IntelliJ IDEA.
  User: HOANGANH
  Date: 10/26/2023
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidates</title>
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
