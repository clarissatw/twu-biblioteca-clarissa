package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.controller.Library;

public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaController bibliotecaController = new BibliotecaController(new Library());

        System.out.println(bibliotecaController.getWelcomeMessage());

        bibliotecaController.getBooksList().forEach(System.out::println);

    }
}
