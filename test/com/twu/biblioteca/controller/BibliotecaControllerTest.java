package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class BibliotecaControllerTest {


    @Test
    public void shouldShowCorrectWelcomeMessageWhenApplicationStarts() {

        BibliotecaController bibliotecaController = new BibliotecaController();

        String welcomeMessage = bibliotecaController.getWelcomeMessage();

        assertThat(welcomeMessage, is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void shouldShowListOfAllLibraryBooksWhenAfterWelcomeMessage(){
        Library library =  new Library();

        List<Book> allBooks = library.getAllBooks();

        assertEquals(2, allBooks.size());

    }
}
