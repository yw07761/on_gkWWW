package com.example.demo1.controllers;

import com.example.demo1.models.Candidate;
import com.example.demo1.models.Roles;
import com.example.demo1.repository.CandidateRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/cau5")
public class Cau5Controller extends HttpServlet {
    private final CandidateRepository candidateRepository = new CandidateRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roles = req.getParameter("roles");
        int role_value = 0;
        switch (roles) {
            case "ADMINISTRATION": break;
            case "STAFF":
                role_value = 1;
                break;
            case "MANAGER":
                role_value = 2;
                break;
            case "EXECUTIVE":
                role_value = 3;
                break;
        }
        List<Candidate> candidates = candidateRepository.getCandidatesByRole(role_value);
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        for (Candidate candidate: candidates) {
            writer.println("<p>" + candidate + "</p>");
        }
        writer.println("</body>");
        writer.println("</html>");

    }

}
