package com.saha.complexstructure.inheritance.model;

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

@Entity(name = "com.saha.complexstructure.inheritance.model.Musician")
@Table(name = "musician_i")
public class Musician {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "first_name", length = 50)
  private String firstName;

  @Column(name = "last_name", length = 50)
  private String lastName;

  @JoinColumn(name = "cd_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private CD cd;

  public Musician() {
  }

  public Musician(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
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

  public CD getCd() {
    return cd;
  }

  public void setCd(CD cd) {
    this.cd = cd;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Musician{");
    sb.append("id=").append(id);
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
