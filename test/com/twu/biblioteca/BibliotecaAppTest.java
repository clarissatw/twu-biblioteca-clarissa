package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.text.StringContainsInOrder.stringContainsInOrder;

public class BibliotecaAppTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void shouldTestOutputOrderwhenBibliotecaApplicationStarts() {

        BibliotecaApp.main(null);

        String welcomeMessage = outputStreamCaptor.toString().trim();

        assertThat(welcomeMessage, startsWith(BibliotecaController.WELCOME_MESSAGE));
    }

    @Test
    public void shouldListAllLibraryBooksAfterWelcomeMessageWhenApplicationStarts() {
        String expectedBookList = "Manual Antirracista;Djamila Ribeiro;2019\n" +
                "Admiravel Mundo Novo;Aldous Leonard Huxley;1932";
        BibliotecaApp.main(null);
        String terminalMessage = outputStreamCaptor.toString().trim();
        assertThat(terminalMessage, stringContainsInOrder(BibliotecaController.WELCOME_MESSAGE, expectedBookList));
    }


}
