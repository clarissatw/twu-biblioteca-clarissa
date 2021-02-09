package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final static String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    @Test
    public void shouldShowCorrectWelcomeMessageWhenApplicationStarts() {

        System.setOut(new PrintStream(outputStreamCaptor));

        BibliotecaApp.main(null);

        assertEquals(WELCOME_MESSAGE, outputStreamCaptor.toString().trim());
        assertEquals(1, 1);
    }

}
