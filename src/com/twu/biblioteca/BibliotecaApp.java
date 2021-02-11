package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.controller.Library;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        startLibraryApp();


    }

    private static void startLibraryApp() {
        BibliotecaController bibliotecaController = new BibliotecaController(new Library());

        System.out.println(bibliotecaController.getWelcomeMessage());

        int choice = 0;

        Scanner scanner = new Scanner(System.in);
        do {
            bibliotecaController.printMenu();


            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }

            if(choice == 1){
                bibliotecaController.getBooksList().forEach(System.out::println);
            }






        } while (choice != 0);
    }
}
