package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.controller.Library;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaController bibliotecaController = new BibliotecaController(new Library());

        System.out.println(bibliotecaController.getWelcomeMessage());

        System.out.println(bibliotecaController.getMenuOfOptions());

        Scanner scanner = new Scanner(System.in);

        int choice = 0;


        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        }

        if (choice == 1) {
            bibliotecaController.getBooksList().forEach(System.out::println);
        }


    }
}
