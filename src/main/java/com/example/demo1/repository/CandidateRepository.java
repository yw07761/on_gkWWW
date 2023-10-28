package com.example.demo1.repository;

import com.example.demo1.connect.Connection;
import com.example.demo1.models.Candidate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class CandidateRepository {
    private final EntityManagerFactory emf = Connection.getInstance().getEntityManagerFactory();

    public void insert(Candidate candidate) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try{
            tr.begin();
            em.persist(candidate);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            throw new RuntimeException(e);
        }
    }

    public List<Candidate> getAll() {
        List<Candidate> candidates;
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try{
            tr.begin();
            candidates = em.createQuery("from candidate", Candidate.class).getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            throw new RuntimeException(e);
        }
        return candidates;
    }

    public List<Candidate> getCandidatesByRole(int role) {
        List<Candidate> candidates;
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try{
            tr.begin();
            candidates = em.createNamedQuery("getCandidatesByRole", Candidate.class)
                    .setParameter(1, role).getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            throw new RuntimeException(e);
        }
        return candidates;
    }

    public List<Candidate> getCandidatesIsGmail() {
        List<Candidate> candidates;
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try{
            tr.begin();
            candidates = em.createNamedQuery("getCandidatesIsGmail", Candidate.class).getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            throw new RuntimeException(e);
        }
        return candidates;
    }
}
