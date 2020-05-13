package com.saha.complexstructure.mapping.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "musician_m")
@Getter @Setter
public class Musician {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @JoinColumn(name = "cd_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private CD cd;

  public Musician(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Musician{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName +
            '}';
  }
}