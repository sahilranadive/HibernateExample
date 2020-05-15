package com.saha.entitylisteners.model;

import com.saha.complexstructure.mapping.model.CD;
import com.saha.entitylisteners.listeners.AgeCalculationListener;
import com.saha.entitylisteners.listeners.ValidationListener;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "com.saha.entitylisteners.model.Musician")
@Table(name = "musician_l")
@Getter @Setter
@EntityListeners({ValidationListener.class, AgeCalculationListener.class})
public class Musician {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "date_of_birth")
  private Long dateOfBirth;

  @Transient
  private Integer age;

  public Musician(String firstName, String lastName, Long dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString() {
    return "Musician{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName +
            ", age='" + age +
            '}';
  }
}