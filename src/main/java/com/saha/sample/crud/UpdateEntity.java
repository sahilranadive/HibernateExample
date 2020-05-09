package com.saha.sample.crud;

import com.saha.model.Book;
import com.saha.persistence.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UpdateEntity {

    private static EntityManager em = PersistenceManager.getEntityManager();
    private static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {
        Book book1 = em.find(Book.class, 13L);
        System.out.println(book1);

        tx.begin();
        book1.setUnitCost(book1.getUnitCost() + 10);
        tx.commit();

        System.out.println("After update");
        System.out.println(em.find(Book.class, 13L));

        em.close();
        PersistenceManager.close();
    }
}
