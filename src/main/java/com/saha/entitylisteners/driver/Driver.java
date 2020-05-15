package com.saha.entitylisteners.driver;

import com.saha.entitylisteners.model.Musician;
import com.saha.persistence.PersistenceManager;
import com.saha.service.CrudService;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Driver {
    private static EntityManager em = PersistenceManager.getEntityManager();
    private static EntityTransaction tx = em.getTransaction();
    private static CrudService<Musician> musicianService = new CrudService<>(Musician.class, em);

    public static void main(String[] args) {

        Musician musicianWithNoName = new Musician("", "", null);
        create(musicianWithNoName);

        Musician musicianWithNoAge = new Musician("Blah", "bla", null);
        create(musicianWithNoAge);
        System.out.println(musicianService.findById(musicianWithNoAge.getId()));


        Musician musicianWithAge = new Musician("Blah", "bla", LocalDate.of(1991, 12, 5).toEpochDay());
        create(musicianWithAge);
        System.out.println(musicianService.findById(musicianWithAge.getId()));

    }

    private static void create(Musician musician) {
        tx.begin();
        musicianService.create(musician);
        tx.commit();
    }
}
