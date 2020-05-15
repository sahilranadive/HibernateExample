package com.saha.entitylisteners.listeners;

import com.saha.entitylisteners.model.Musician;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class AgeCalculationListener {

    @PostLoad
    @PostPersist
    @PostUpdate
    public void calculateAge(Musician musician) {
        System.out.println("In AgeCalculationListener");
        Integer age = null;
        if (musician.getDateOfBirth() != null) {
            age = Period.between(LocalDate.ofEpochDay(musician.getDateOfBirth()), LocalDate.now()).getYears();
        }
        musician.setAge(age);
    }
}
