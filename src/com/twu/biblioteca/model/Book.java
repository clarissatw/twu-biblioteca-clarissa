package com.twu.biblioteca.model;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String yearPublished;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(yearPublished, book.yearPublished);
    }

    @Override
    public String toString() {
        return title + ";" + author+ ";" + yearPublished;
    }
}
