package com.mypack.mypack;

import com.mypack.mypack.entities.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Persistence;


public class ma {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Admin admin = new Admin();
        admin.setFirst_name("Jawad");
        admin.setLast_name("DOUFARE");
        admin.setEmail("jd@administration.com");
        admin.setPassword("adminnidma");
        em.persist(admin);
        em.getTransaction().commit();

    }
}
