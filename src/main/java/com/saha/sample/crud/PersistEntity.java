package com.saha.sample.crud;

import com.saha.model.*;
import com.saha.persistence.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersistEntity {

  private static EntityManager em = PersistenceManager.getEntityManager();
  private static EntityTransaction tx = em.getTransaction();

  public static void main(String[] args) {

    Book book = new Book();
    book.setId(13L);
    book.setTitle("H2G2");
    book.setDescription("Best IT Scifi Book");
    book.setUnitCost(12.5f);
    book.setIsbn("1234-5678-5678");
    book.setNbOfPage(247);


    tx.begin();
    em.persist(book);
    tx.commit();

    em.close();
    PersistenceManager.close();
  }
}


