package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> libraryList = new ArrayList<>();

    public List<Book> getAllBooks() {
        libraryList = List.of(new Book("Manual Antirracista","Djamila Ribeiro"), new Book("Admiravel Mundo Novo"," Aldous Leonard Huxley "));

        return libraryList;
    }
}
