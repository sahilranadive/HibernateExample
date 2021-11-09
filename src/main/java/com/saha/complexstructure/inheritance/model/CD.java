package com.saha.complexstructure.inheritance.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "com.saha.complexstructure.inheritance.model.CD")
@ToString(callSuper = true)
@Table(name = "cd_i")
public class CD extends Item {

  @Column(name = "total_duration")
  private Float totalDuration;

  @Column(name = "genre")
  private String genre;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "cd")
  private Set<Musician> musicians = new HashSet<>();

  public CD() {
  }

  public CD(String title) {
    this.title = title;
  }

  public CD(String title, String genre) {
    this.title = title;
    this.genre = genre;
  }

  public CD(String title, String description, Float unitCost, Float totalDuration, String genre) {
    this.title = title;
    this.description = description;
    this.unitCost = unitCost;
    this.totalDuration = totalDuration;
    this.genre = genre;
  }

  public Float getTotalDuration() {
    return totalDuration;
  }

  public void setTotalDuration(Float totalDuration) {
    this.totalDuration = totalDuration;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Set<Musician> getMusicians() {
    return musicians;
  }

  public void setMusicians(Set<Musician> musicians) {
    this.musicians = musicians;
  }
}
