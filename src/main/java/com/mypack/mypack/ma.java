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
        admin.setFirst_name("ahmed");
        admin.setLast_name("mohamadi");
        admin.setEmail("admin@administration.com");
        admin.setPassword("admin");
        em.persist(admin);
        em.getTransaction().commit();

    }
}
