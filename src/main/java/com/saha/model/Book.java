package com.saha.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@Data
public class Book {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  private Long id;

  private String title;
  private String description;
  private Float unitCost;
  private String isbn;
  private Integer nbOfPage;
}