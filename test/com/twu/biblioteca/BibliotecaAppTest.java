package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.model.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void shouldShowWelcomeMessageWhenLibraryApplicationStarts() {
        inputToTest("0\n");
        BibliotecaApp.main(null);

        String welcomeMessage = outputStreamCaptor.toString().trim();

        assertThat(welcomeMessage, startsWith(BibliotecaController.WELCOME_MESSAGE));
    }

    @Test
    public void shouldListAllLibraryBooksWhenAfterSelectTheBookListOption() {
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
    public void shouldShowMenuOptionsWhenRightAfterWelcomeMessage(){

        Menu menu = new Menu();
        String textMenuFormatted = menu.getMenuFormatted();
        inputToTest("0\n");
        BibliotecaApp.main(null);

        String terminalMessage = outputStreamCaptor.toString().trim();

        assertThat(terminalMessage, containsString(textMenuFormatted.trim()));


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
    public void shouldNotifyTheCustomerWhenWriteSpellingErrorOnCheckOut(){

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

    @Test
    public void shouldHaveReturnBookOptionWhenShowMenu(){
        inputToTest("0\n");

        BibliotecaApp.main(null);
        String terminalMessage = outputStreamCaptor.toString();
        assertThat(terminalMessage, containsString("Return a Book"));

    }

    @Test
    public void shouldNotifyTheCustomerWhenTheyReturnABookSuccessfully(){

        inputToTest("2\nManual Antirracista\n3\nManual Antirracista\n0\n");

        BibliotecaApp.main(null);

        //when
        String terminalMessage = outputStreamCaptor.toString();

        //than
        assertThat(terminalMessage, containsString("Thank you for returning the book"));
    }

    @Test
    public void shouldNotifyTheCustomerWhenNotReturnAValidBook(){

        inputToTest("2\nManual Antirracista\n3\nA Espera de um Milagre\n0\n0\n");

        BibliotecaApp.main(null);

        //when
        String terminalMessage = outputStreamCaptor.toString();

        //than
        assertThat(terminalMessage, containsString("That is not a valid book to return."));
    }


}
