package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Menu {

    private List<String> options;

    public Menu() {
        this.options = new ArrayList<>();
        options.add("Quit");
        options.add("List of Books");
        options.add("Check Out");
        options.add("Return a Book");
    }

    public List<String> getOptions() {
        return options;
    }

    public Optional<String> selectOption(int optionNumber) {

        if (optionNumber < 0 || optionNumber > options.size()) {
            return Optional.of("Please select a valid option!");
        }
        return Optional.of(this.options.get(optionNumber));
    }

    public void print() {
        System.out.print(this.getMenuFormatted());
    }

    public String getMenuFormatted() {
        StringBuilder menu = new StringBuilder();
        for (int i = 0; i < this.getOptions().size(); i++) {
            menu.append(i + " - " + this.getOptions().get(i) + "\n");
        }
        return menu.toString();
    }
}
