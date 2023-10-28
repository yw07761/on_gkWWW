package com.example.demo1.connect;

import com.example.demo1.models.Candidate;
import com.example.demo1.models.Experience;
import com.example.demo1.models.Roles;
import com.example.demo1.repository.CandidateRepository;
import com.example.demo1.repository.ExperienceRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

import java.time.LocalDate;


@Getter

public class Connection {
    private static Connection instance;
    private final EntityManagerFactory entityManagerFactory;


    private Connection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("onthi");
    }

    public static Connection getInstance() {
        if(instance == null)
            instance = new Connection();
        return instance;
    }

    public static void main(String[] args) {
        CandidateRepository candidateRepository = new CandidateRepository();
        ExperienceRepository experienceRepository = new ExperienceRepository();
        for(int i = 0; i < 3; i++) {
            Candidate candidate = new Candidate();
            candidate.setFullName("candidate" + i);
            candidate.setPhone("999999999");
            candidate.setEmail("candidate" + i + "@gmail.com");
            candidateRepository.insert(candidate);
            for(int j = 0; j < 3; j++) {
                Experience experience = new Experience();
                experience.setCandidate(candidate);
                Roles roles = Roles.MANAGER;
                switch (j) {
                    case 0:
                        roles = Roles.ADMINISTRATION; break;
                    case 1:
                        roles = Roles.STAFF; break;
                    case 2:
                        roles = Roles.EXECUTIVE; break;
                }
                experience.setRole(roles);
                experience.setToDate(LocalDate.of(2023, 10, 26));
                experience.setFromDate(LocalDate.of(2024, 10, 26));
                experience.setCompanyName("fasddsaf");
                experience.setWorkDescription("afasffa");
                experienceRepository.insert(experience);
            }
        }
    }
}
