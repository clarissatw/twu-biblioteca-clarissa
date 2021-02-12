package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;

public class LibraryTest {
    Library library;

    @Before
    public void setUp(){
        library = new Library();
    }
    @Test
    public void shouldNotAppearABookOnTheListWhenABookIsCheckedOut(){

        Book bookCheckedOut = library.checkOutBook("Manual Antirracista");

        assertThat(library.getAllBooks(), not(hasItem(bookCheckedOut)));
    }

    @Test
    public void shouldAppearABookOnTheListWhenABookIsReturned(){
        Book bookCheckedOut = library.checkOutBook("Manual Antirracista");

        Book returnedBook = library.returnBook(bookCheckedOut.getTitle());

        assertThat(library.getAllBooks(), hasItem(returnedBook));
    }
}
