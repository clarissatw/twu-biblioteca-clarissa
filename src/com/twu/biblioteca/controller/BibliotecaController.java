package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BibliotecaController {

    public final static String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private Menu menu;
    private Library library;

    public BibliotecaController(Library library) {
        this.library = library;
        this.menu = new Menu();
    }

    public void startApp(BibliotecaController bibliotecaController) {
        System.out.println(WELCOME_MESSAGE);

        String choice = null;

        Scanner scanner = new Scanner(System.in);
        do {
            bibliotecaController.printMenu();


            if (scanner.hasNextLine()) {

                choice = scanner.nextLine();

            }

            selectOptions(choice, scanner);


        } while (!choice.equals("0"));
    }

    private void selectOptions(String choice, Scanner scanner) {
        if(!choice.isEmpty()){
            if (choice.equals("1")) {
                getBooksList().forEach(System.out::println);
            }

            if (choice.equals("2")) {
                String bookTitle = "";
                do {
                    System.out.println("Please, type the book title");

                    if (scanner.hasNextLine()) {
                        bookTitle = scanner.nextLine();
                    }

                    Book book = checkout(bookTitle);

                    if (book != null) {
                        System.out.println("Thank you! Enjoy the book");
                        break;
                    } else {
                        System.out.println("Sorry, that book is not available");
                    }

                } while(!bookTitle.equals("0"));
            }

            if (choice.equals("3")) {
                String bookTitle = "";
                do {
                    System.out.println("Please, type the book title");

                    if (scanner.hasNextLine()) {
                        bookTitle = scanner.nextLine();
                    }

                    Book book = returnBook(bookTitle);

                    if (book != null) {
                        System.out.println("Thank you for returning the book");
                        break;
                    } else {
                        System.out.println("That is not a valid book to return.");
                    }

                } while(!bookTitle.equals("0"));
            }
        }
    }

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<Book> getBooksList() {
        return library.getAllBooks();
    }

    public Menu getMenuOfOptions() {
        return this.menu;
    }

    public Optional<String> getOption(int optionNumber) {
        return menu.selectOption(optionNumber);
    }

    public void printMenu() {
        menu.print();
    }

    public Book checkout(String bookTitle) {
        return library.checkOutBook(bookTitle);
    }

    public Book returnBook(String bookTitle) {
        return library.returnBook(bookTitle);
    }
}
