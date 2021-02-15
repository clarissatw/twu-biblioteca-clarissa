package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.when;

public class BibliotecaControllerTest {

    @Mock
    Library library;
    BibliotecaController bibliotecaController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        List<Book> bookList = List.of(new Book("Manual Antirracista", "Djamila Ribeiro", "2019"),
                new Book("Admiravel Mundo Novo", "Aldous Leonard Huxley", "1932"));
        when(library.getAllAvailableBooks()).thenReturn(bookList);

        bibliotecaController = new BibliotecaController(library);


    }

    @Test
    public void shouldShowAuthorAndYearPublishedWhenBookListIsShowed() {
        List<Book> bookList = bibliotecaController.getBooksList();

        String actualBookDetails = bookList.get(1).toString();

        String expectedBookDetails = "Admiravel Mundo Novo;Aldous Leonard Huxley;1932";

        assertThat(actualBookDetails, is(expectedBookDetails));
    }

    @Test
    public void shouldShowMenuOfOptionsWhenBeforeBooksList() {
        Menu menu = bibliotecaController.getMenuOfOptions();

        List<String> options = menu.getOptions();

        assertThat(options, hasItems("List of Books"));
    }

    @Test
    public void shouldShowInvalidMessageWhenChooseAnInvalidOption() {
        String invalidOption = bibliotecaController.getOption(-1).get();

        assertThat(invalidOption, is("Please select a valid option!"));

    }

    @Test
    public void shouldExitApplicationWhenChooseOptionToQuit() {
        String quitOption = bibliotecaController.getOption(0).get();

        assertThat(quitOption, is("Quit"));

    }

    @Test
    public void shouldShowCheckOutOptionWhenMenuOptionsAppears() {
        String checkOutOption = bibliotecaController.getOption(2).get();

        assertThat(checkOutOption, is("Check Out"));

    }

}
