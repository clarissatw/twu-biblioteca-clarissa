package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.model.Message;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BibliotecaController {

    private Menu menu;
    private Library library;

    public BibliotecaController(Library library) {
        this.library = library;
        this.menu = new Menu();
    }

    public void startApp() {
        System.out.println(Message.WELCOME_MESSAGE.getDescription());

        showMainMenu();
    }

    private void showMainMenu() {
        String choice = null;

        Scanner scanner = new Scanner(System.in);
        do {
            printMenu();

            if (scanner.hasNextLine()) {
                choice = scanner.nextLine();
            }

            selectOption(choice, scanner);

        } while (!choice.equals("0"));
    }

    public void printMenu() {
        menu.print();
    }

    private void selectOption(String choice, Scanner scanner) {
        if (!choice.isEmpty()) {
            if (choice.equals("1")) {
                getBooksList().forEach(System.out::println);
            }

            if (choice.equals("2")) {
                String bookTitle = "";
                do {
                    System.out.println(Message.TYPE_BOOK_TITLE.getDescription());

                    if (scanner.hasNextLine()) {
                        bookTitle = scanner.nextLine();
                    }

                    Book book = checkout(bookTitle);

                    if (book != null) {
                        System.out.println(Message.SUCCESSFULLY_CHECKOUT.getDescription());
                        break;
                    } else {
                        System.out.println(Message.NOT_AVAILABLE_CHECKOUT.getDescription());
                    }

                } while (!bookTitle.equals("0"));
            }

            if (choice.equals("3")) {
                String bookTitle = "";
                do {
                    System.out.println(Message.TYPE_BOOK_TITLE.getDescription());

                    if (scanner.hasNextLine()) {
                        bookTitle = scanner.nextLine();
                    }

                    Book book = returnBook(bookTitle);

                    if (book != null) {
                        System.out.println(Message.SUCCESSFULLY_RETURN_BOOK.getDescription());
                        break;
                    } else {
                        System.out.println(Message.NOT_VALID_BOOK_TO_RETURN.getDescription());
                    }

                } while (!bookTitle.equals("0"));
            }
        }
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

    public Book checkout(String bookTitle) {
        return library.checkOutBook(bookTitle);
    }

    public Book returnBook(String bookTitle) {
        return library.returnBook(bookTitle);
    }
}
