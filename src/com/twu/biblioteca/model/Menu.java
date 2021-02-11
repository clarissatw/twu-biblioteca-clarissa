package com.twu.biblioteca.model;

import com.twu.biblioteca.controller.Library;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<String> options;

    public Menu() {
        this.options = new ArrayList<>();
        options.add("List of Books");
    }

    public List<String> getOptions() {
        return options;
    }

    public String selectOption(int optionNumber) {
        if(optionNumber < 0 || optionNumber > options.size()){
            return "Please select a valid option!";
        }
        return this.options.get(optionNumber-1);
    }
}
