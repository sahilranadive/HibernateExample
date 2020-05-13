package com.saha.complexstructure.inheritance.driver;

import com.saha.complexstructure.inheritance.model.Book;
import com.saha.complexstructure.inheritance.model.CD;
import com.saha.complexstructure.inheritance.model.Musician;
import com.saha.persistence.PersistenceManager;
import com.saha.service.CrudService;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Driver {

    private static EntityManager em = PersistenceManager.getEntityManager();
    private static EntityTransaction tx = em.getTransaction();

    public static void main(String[] args) {

        CrudService<CD> cdService = new CrudService<>(CD.class, em);

        Set<Musician> beatles = new HashSet<>();
        beatles.add(new Musician("John", "Lennon"));
        beatles.add(new Musician("Paul", "McCartney"));
        beatles.add(new Musician("Ringo", "Starr"));
        beatles.add(new Musician("Georges", "Harrison"));
        CD sergentPepper = new CD("Sergent Pepper", "Awesome collection", 30f, 270f, "pop");
        sergentPepper.setMusicians(beatles);
        // This mapping is most important to provide to tell hibernate
        // that this parent entity belong to the given child entity ie this cd contains the given musician
        for (Musician musician : beatles) {
            musician.setCd(sergentPepper);
        }
        tx.begin();
        cdService.create(sergentPepper);
        tx.commit();

        CrudService<Book> bookService = new CrudService<>(Book.class, em);
        Book book = new Book("H2G2", "Best IT Scifi Book", 12.5f, "1234-5678-5678", 247);
        tx.begin();
        bookService.create(book);
        tx.commit();

        tx.begin();
        System.out.println(cdService.findById(sergentPepper.getId()).toString());
        System.out.println(bookService.findById(book.getId()).toString());
        tx.commit();

        em.close();
        PersistenceManager.close();
    }
}
