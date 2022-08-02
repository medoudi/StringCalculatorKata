package com.exalt.company.model;

public class SeparatedNumbersAndDelimitter {
    String delimitter;
    String numbers;

    public SeparatedNumbersAndDelimitter(String delimitter, String numbers) {
        this.delimitter = new String(delimitter);
        this.numbers = new String(numbers);
    }

    public String getDelimitter() {
        return new String(delimitter);
    }

    public void setDelimitter(String delimitter) {
        this.delimitter = new String(delimitter);
    }

    public String getNumbers() {
        return new String(numbers);
    }

    public void setNumbers(String numbers) {
        this.numbers = new String(numbers);
    }
}
