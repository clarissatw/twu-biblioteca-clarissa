package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class BibliotecaControllerTest {


    @Test
    public void shouldShowCorrectWelcomeMessageWhenApplicationStarts() {

        BibliotecaController bibliotecaController = new BibliotecaController();

        String welcomeMessage = bibliotecaController.getWelcomeMessage();

        assertThat(welcomeMessage, is(BibliotecaController.WELCOME_MESSAGE));
    }

    @Test
    public void shouldShowListOfAllLibraryBooksWhenAfterWelcomeMessage() {
        BibliotecaController bibliotecaController = new BibliotecaController();

        List<Book> actualBookList = bibliotecaController.getBooksList();

        assertThat(actualBookList, containsInAnyOrder(new Book("Manual Antirracista", "Djamila Ribeiro"), new Book("Admiravel Mundo Novo", " Aldous Leonard Huxley ")));

    }


}
