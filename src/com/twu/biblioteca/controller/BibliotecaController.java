package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {

    public final static String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    private Library library;

    public BibliotecaController(Library library) {
        this.library = library;
    }

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<Book> getBooksList() {
        return library.getAllBooks();
    }
}
