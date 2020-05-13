package com.saha.complexstructure.inheritance.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "com.saha.complexstructure.inheritance.model.Book")
@Getter @Setter @ToString(callSuper = true)
@Table(name = "book_i")
public class Book extends Item {

  @Column(length = 15)
  private String isbn;

  @Column(name = "nb_of_pages")
  private Integer nbOfPage;

  public Book() {
  }

  public Book(String title) {
    this.title = title;
  }

  public Book(String title, String isbn) {
    this.title = title;
    this.isbn = isbn;
  }

  public Book(String title, String description, Float unitCost, String isbn, Integer nbOfPage) {
    this.title = title;
    this.description = description;
    this.unitCost = unitCost;
    this.isbn = isbn;
    this.nbOfPage = nbOfPage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Book book = (Book) o;

    if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
    if (nbOfPage != null ? !nbOfPage.equals(book.nbOfPage) : book.nbOfPage != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
    result = 31 * result + (nbOfPage != null ? nbOfPage.hashCode() : 0);
    return result;
  }
}