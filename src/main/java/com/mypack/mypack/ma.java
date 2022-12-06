package com.mypack.mypack;

import com.mypack.mypack.entities.Admin;

import com.mypack.mypack.services.AuthentificationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Persistence;


public class ma {
    public static void main(String[] args) {

      new AuthentificationService().login("jawad@admin.com","12121212");

    }
}
