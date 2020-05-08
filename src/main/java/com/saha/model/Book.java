package com.saha.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@Data
public class Book {

  @Id
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "unitCost")
  private Float unitCost;

  @Column(name = "isbn")
  private String isbn;

  @Column(name = "nbOfPage")
  private Integer nbOfPage;
}