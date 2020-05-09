package com.saha.driver;

import com.saha.model.*;
import com.saha.persistence.PersistenceManager;

import javax.persistence.EntityManager;

public class PersistEntity {

  public static void main(String[] args) {

    Book book = new Book();
    book.setId(13L);
    book.setTitle("H2G2");
    book.setDescription("Best IT Scifi Book");
    book.setUnitCost(12.5f);
    book.setIsbn("1234-5678-5678");
    book.setNbOfPage(247);

    EntityManager em = PersistenceManager.getEntityManager();
    em.getTransaction()
            .begin();
    em.persist(book);
    em.getTransaction()
            .commit();
    em.close();

    PersistenceManager.close();
  }
}


