package com.saha.entitylisteners.listeners;

import com.mysql.jdbc.StringUtils;
import com.saha.entitylisteners.model.Musician;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class ValidationListener {

    @PrePersist
    @PreUpdate
    public void validate(Musician musician) {
        System.out.println("In ValidationListener");
        if (StringUtils.isNullOrEmpty(musician.getFirstName())) {
            System.out.println("Firstname is invalid");
        } else if (StringUtils.isNullOrEmpty(musician.getLastName())) {
            System.out.println("Lastname is invalid");
        }
    }
}
