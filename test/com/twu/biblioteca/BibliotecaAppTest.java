package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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

        assertThat(welcomeMessage, is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }


}
