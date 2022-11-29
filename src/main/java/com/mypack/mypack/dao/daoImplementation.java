package com.mypack.mypack.dao;

import com.mypack.mypack.utilityClassees.entityUtility;
import com.sun.tools.javac.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Map;

public class daoImplementation<T> implements dao<T>{
    @Override
    public T get(Class<T> beanClass, Integer id) {
        EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
        try{
            return entityManager.find(beanClass,id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean save(T object) {
        EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(T object) {
        EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(object);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteId(Class<T> beanClass,int id) {
        EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
        try{
            entityManager.getTransaction().begin();
            T object = entityManager.find(beanClass,id);
            T obj = entityManager.merge(object);
            entityManager.remove(obj);
            entityManager.getTransaction().commit();
            return true;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<T> getAll(Class<T> beanClass) {
        EntityManager entityManager = entityUtility.getEntityManagerFactory().createEntityManager();
        try{

            TypedQuery<T> query = entityManager.createQuery("SELECT a FROM "+beanClass.getSimpleName()+" a",beanClass);

            return (List<T>) query.getResultList();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }



}
