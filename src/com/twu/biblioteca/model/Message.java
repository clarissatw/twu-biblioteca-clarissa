package com.twu.biblioteca.model;

public enum Message {

    WELCOME_MESSAGE("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"),
    TYPE_BOOK_TITLE("Please, type the book title"),
    INVALID_OPTION("Please select a valid option!"),
    SUCCESSFULLY_CHECKOUT("Thank you! Enjoy the book"),
    NOT_AVAILABLE_CHECKOUT("Sorry, that book is not available"),
    SUCCESSFULLY_RETURN_BOOK("Thank you for returning the book"),
    NOT_VALID_BOOK_TO_RETURN("That is not a valid book to return.");

    private final String description;

    Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
