package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;

public class LibraryTest {
    Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void shouldShowListOfAllLibraryBooksWhenAfterWelcomeMessage() {
        List<Book> actualBookList = library.getBooksList();

        assertThat(actualBookList, hasSize(2));
    }

    @Test
    public void shouldNotAppearABookOnTheListWhenABookIsCheckedOut() {

        Book bookCheckedOut = library.checkOutBook("Manual Antirracista");

        assertThat(library.getAllAvailableBooks(), not(hasItem(bookCheckedOut)));
    }

    @Test
    public void shouldAppearABookOnTheListWhenABookIsReturned() {
        Book bookCheckedOut = library.checkOutBook("Manual Antirracista");

        Book returnedBook = library.returnBook(bookCheckedOut.getTitle());

        assertThat(library.getAllAvailableBooks(), hasItem(returnedBook));
    }
}
