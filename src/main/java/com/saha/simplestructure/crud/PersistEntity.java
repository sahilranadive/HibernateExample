package com.saha.simplestructure.crud;

import com.saha.complexstructure.mapping.model.CD;
import com.saha.service.CrudService;
import com.saha.simplestructure.model.*;
import com.saha.persistence.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersistEntity {

  private static EntityManager em = PersistenceManager.getEntityManager();
  private static EntityTransaction tx = em.getTransaction();

  public static void main(String[] args) {

    CrudService<Book> service = new CrudService<>(Book.class, em);

    Book book = new Book();
    book.setTitle("H2G2");
    book.setDescription("Best IT Scifi Book");
    book.setUnitCost(12.5f);
    book.setIsbn("1234-5678-5678");
    book.setNbOfPage(247);


    tx.begin();
    service.create(book);
    tx.commit();

    em.close();
    PersistenceManager.close();
  }
}


