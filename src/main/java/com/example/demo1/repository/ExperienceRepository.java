package com.example.demo1.repository;

import com.example.demo1.connect.Connection;
import com.example.demo1.models.Experience;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ExperienceRepository {
    private final EntityManagerFactory emf = Connection.getInstance().getEntityManagerFactory();

    public void insert(Experience experience) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try{
            tr.begin();
            em.persist(experience);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            throw new RuntimeException(e);
        }
    }

    public List<Experience> getExperiencesByCanId(long can_id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        List<Experience> experiences;
        try{
            tr.begin();
            experiences = em.createNamedQuery("getExperiencesByCanId", Experience.class)
                    .setParameter(1, can_id).getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            throw new RuntimeException(e);
        }
        return experiences;
    }
}
