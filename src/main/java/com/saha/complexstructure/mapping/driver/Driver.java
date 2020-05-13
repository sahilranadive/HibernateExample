package com.saha.complexstructure.mapping.driver;

import com.saha.complexstructure.mapping.model.CD;
import com.saha.complexstructure.mapping.model.Musician;
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

        CrudService<CD> service = new CrudService<>(CD.class, em);

        Set<Musician> beatles = new HashSet<>();
        beatles.add(new Musician("John", "Lennon"));
        beatles.add(new Musician("Paul", "McCartney"));
        beatles.add(new Musician("Ringo", "Starr"));
        beatles.add(new Musician("Georges", "Harrison"));
        CD sergentPepper = new CD("Sergent Pepper");
        sergentPepper.setMusicians(beatles);

        // This mapping is most important to provide to tell hibernate
        // that this parent entity belong to the given child entity ie this cd contains the given musician
        for (Musician musician : beatles) {
            musician.setCd(sergentPepper);
        }
        tx.begin();
        service.create(sergentPepper);
        tx.commit();

        tx.begin();
        CD cd = service.findById(sergentPepper.getId());
        System.out.println(cd.toString());
        tx.commit();

        em.close();
        PersistenceManager.close();
    }
}
