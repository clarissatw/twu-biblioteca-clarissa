package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.model.Menu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.text.StringContainsInOrder.stringContainsInOrder;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void shouldTestOutputOrderwhenBibliotecaApplicationStarts() {
        inputToTest("0\n");
        BibliotecaApp.main(null);

        String welcomeMessage = outputStreamCaptor.toString().trim();

        assertThat(welcomeMessage, startsWith(BibliotecaController.WELCOME_MESSAGE));
    }

    @Test
    public void shouldListAllLibraryBooksAfterSelectTheBookListOption() {
        String expectedBookList = "Manual Antirracista;Djamila Ribeiro;2019\n" +
                "Admiravel Mundo Novo;Aldous Leonard Huxley;1932";

        inputToTest("1\n0\n");

        BibliotecaApp.main(null);

        //when
        String terminalMessage = outputStreamCaptor.toString();

        //than
        assertThat(terminalMessage, containsString(expectedBookList));
    }

    private void inputToTest(String inputStr) {
        InputStream sysIn = System.in;
        ByteArrayInputStream input = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(input);
    }

    @Test
    public void name() {
    }

    @Test
    public void shouldShowMenuOptionsWhenRightAfterWelcomeMessage(){

        Menu menu = new Menu();
        String textMenuFormatted = menu.getMenuFormatted();
        inputToTest("0\n");
        BibliotecaApp.main(null);

        String x = "\n0 - Quit\n" +
                "1 - List of Books\n" +
                "2 - Check Out\n";

        String terminalMessage = outputStreamCaptor.toString().trim();

        assertThat(terminalMessage, stringContainsInOrder(BibliotecaController.WELCOME_MESSAGE, "0 - Quit\n" , "1 - List of Books\n"));


    }

    @Test
    public void shouldNotifyTheCustomerWhenTheyCheckOutABookSuccessfully(){

        inputToTest("2\nManual Antirracista\n0\n");

        BibliotecaApp.main(null);

        //when
        String terminalMessage = outputStreamCaptor.toString();

        //than
        assertThat(terminalMessage, containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldNotifyTheCustomerWhenWriteSpellingError(){

        inputToTest("2\nManual Anti racsta\nManual Antirracista\n0\n");

        BibliotecaApp.main(null);

        //when
        String terminalMessage = outputStreamCaptor.toString();

        //than
        assertThat(terminalMessage, containsString("Sorry, that book is not available"));
    }

    @Test
    public void shouldNotifyTheCustomerWhenCheckOutNotAvailableBook(){

        inputToTest("2\nManual Antirracista\n2\nManual Antirracista\n0\n0\n");

        BibliotecaApp.main(null);

        //when
        String terminalMessage = outputStreamCaptor.toString();

        //than
        assertThat(terminalMessage, containsString("Sorry, that book is not available"));
    }



}
