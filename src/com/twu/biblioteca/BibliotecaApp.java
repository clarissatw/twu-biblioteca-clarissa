package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaController bibliotecaController = new BibliotecaController();

        System.out.println(bibliotecaController.getWelcomeMessage());

        bibliotecaController.getBooksList().forEach(System.out::println);

    }
}
