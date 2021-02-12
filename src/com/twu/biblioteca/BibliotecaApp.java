package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.model.Book;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        startLibraryApp();


    }

    private static void startLibraryApp() {
        BibliotecaController bibliotecaController = new BibliotecaController(new Library());

        System.out.println(bibliotecaController.getWelcomeMessage());

        String choice = null;

        Scanner scanner = new Scanner(System.in);
        do {
            bibliotecaController.printMenu();


            if (scanner.hasNextLine()) {

                choice = scanner.nextLine();

            }

            if(!choice.isEmpty()){
                if (choice.equals("1")) {
                    bibliotecaController.getBooksList().forEach(System.out::println);
                }

                if (choice.equals("2")) {
                    String bookTitle = "";
                    do {
                        System.out.println("Please, type the book title");

                        if (scanner.hasNextLine()) {
                            bookTitle = scanner.nextLine();
                        }

                        Book book = bibliotecaController.checkout(bookTitle);

                        if (book != null) {
                            System.out.println("Thank you! Enjoy the book");
                            break;
                        } else {
                            System.out.println("Sorry, that book is not available");
                        }

                    } while(!bookTitle.equals("0"));
                }
            }


        } while (!choice.equals("0"));
    }
}
