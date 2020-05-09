package com.saha.sample.crud;

import com.saha.model.Book;
import com.saha.persistence.PersistenceManager;

import javax.persistence.EntityManager;

// This sample demonstrates that when a entity is fetched twice within the same context,
// first time an actual query is made and then the 2nd time its fetched
// from the persistence context directly ie within the same session.
public class FindEntity {

    public static void main(String[] args) {

        EntityManager em = PersistenceManager.getEntityManager();

        Book book1 = em.find(Book.class, 13L);
        System.out.println(book1);

        Book book2 = em.find(Book.class, 13L);
        System.out.println(book2);

        PersistenceManager.close();

        System.out.println("/*****************************************/");

        //If the same entity is fetched across different session,
        //then separate queries will be fired.
        EntityManager em1 = PersistenceManager.getEntityManager();
        System.out.println(em1.find(Book.class, 13L));
        em1.close();

        EntityManager em2 = PersistenceManager.getEntityManager();
        System.out.println(em2.find(Book.class, 13L));
        em2.close();
        PersistenceManager.close();
    }
}
