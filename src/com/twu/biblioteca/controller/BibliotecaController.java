package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
    public final static String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<Book> getBooksList() {
        Library library = new Library();

        return library.getAllBooks();
    }
}
