package com.example.demo1.controllers;

import com.example.demo1.models.Candidate;
import com.example.demo1.models.Experience;
import com.example.demo1.repository.CandidateRepository;
import com.example.demo1.repository.ExperienceRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/cau4"})
public class Cau4Controller extends HttpServlet {
    private final CandidateRepository candidateRepository = new CandidateRepository();
    private final ExperienceRepository experienceRepository = new ExperienceRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long can_id = Long.parseLong(req.getParameter("can_id"));
        List<Experience> experiences = experienceRepository.getExperiencesByCanId(can_id);
        req.setAttribute("experiences", experiences);
        RequestDispatcher rd = req.getRequestDispatcher("candidates_detail.jsp");
        rd.forward(req, resp);
    }
}
