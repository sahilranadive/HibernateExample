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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Long getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Long dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
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