package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;

import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaController {

    public final static String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private Menu menu;
    private Library library;

    public BibliotecaController(Library library) {
        this.library = library;
        this.menu = new Menu();
    }

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<Book> getBooksList() {
        return library.getAllBooks();
    }

    public String getMenuOfOptions() {
        String menuText = menu.getOptions().stream().map(Object::toString).collect(Collectors.joining("/n"));
        return menuText;
    }

    public String selectOption(int optionNumber) {
        return menu.selectOption(optionNumber);
    }
}
