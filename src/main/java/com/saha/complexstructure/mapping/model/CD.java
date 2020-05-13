package com.saha.complexstructure.mapping.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Getter @Setter @ToString
@Table(name = "cd_m")
public class CD {
  @Id
  @GeneratedValue
  @Column(name = "id")
  protected Long id;

  @Column(name = "title")
  protected String title;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "cd")
  private Set<Musician> musicians = new HashSet<>();

  public CD(String title) {
    this.title = title;
  }
}