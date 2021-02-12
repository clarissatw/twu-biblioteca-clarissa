package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.model.Book;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaController bibliotecaController = new BibliotecaController(new Library());

        bibliotecaController.startApp(bibliotecaController);


    }


}
