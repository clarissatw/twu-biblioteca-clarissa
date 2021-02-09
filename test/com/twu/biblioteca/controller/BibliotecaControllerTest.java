package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

public class BibliotecaControllerTest {

    @Mock
    Library library;
    BibliotecaController bibliotecaController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(library.getAllBooks()).thenReturn(List.of(new Book("Manual Antirracista", "Djamila Ribeiro", "2019"),
                new Book("Admiravel Mundo Novo", "Aldous Leonard Huxley", "1932")));

        bibliotecaController = new BibliotecaController(library);


    }

    @Test
    public void shouldShowCorrectWelcomeMessageWhenApplicationStarts() {

        String welcomeMessage = bibliotecaController.getWelcomeMessage();

        assertThat(welcomeMessage, is(BibliotecaController.WELCOME_MESSAGE));
    }

    @Test
    public void shouldShowListOfAllLibraryBooksWhenAfterWelcomeMessage() {
        List<Book> actualBookList = bibliotecaController.getBooksList();

        assertThat(actualBookList, hasSize(2));
    }

    @Test
    public void shouldShowAuthorAndYearPublishedWhenBookListIsShowed() {
        List<Book> bookList = bibliotecaController.getBooksList();

        String actualBookDetails = bookList.get(1).toString();

        String expectedBookDetails = "Admiravel Mundo Novo;Aldous Leonard Huxley;1932";

        assertThat(actualBookDetails, is(expectedBookDetails));
    }


}
