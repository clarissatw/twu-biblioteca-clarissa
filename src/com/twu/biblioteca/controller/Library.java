package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class Library {

    List<Book> libraryList;

    public Library() {
        this.libraryList = List.of(new Book("Manual Antirracista","Djamila Ribeiro", "2019"),
                new Book("Admiravel Mundo Novo","Aldous Leonard Huxley","1932"));

    }

    public List<Book> getAllBooks() {
        return libraryList.stream().filter(b -> b.isAvailable()).collect(Collectors.toList());
    }

    public Book checkOutBook(String bookTitle) {

        for(Book book: this.getAllBooks()) {
            if( book.getTitle().equalsIgnoreCase(bookTitle)){
                book.setAvailable(false);
                return book;
            }
        }
         return null;

    }

    public Book returnBook(String bookTitle) {
        for(Book book: this.libraryList) {
            if( book.getTitle().equalsIgnoreCase(bookTitle)){
                book.setAvailable(true);
                return book;
            }
        }
        return null;
    }
}
