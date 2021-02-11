package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> libraryList = new ArrayList<>();

    public Library() {
        this.libraryList = List.of(new Book("Manual Antirracista","Djamila Ribeiro", "2019"),
                new Book("Admiravel Mundo Novo","Aldous Leonard Huxley","1932"));

    }

    public List<Book> getAllBooks() {
        return libraryList;
    }
}
