package com.exalt.company;

import com.exalt.company.exception.BadFormatException;
import com.exalt.company.exception.DelimitterException;
import com.exalt.company.exception.NegativeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class StringCalculatorKataTest {

    private StringCalculatorKata StringCalculatorKata;

    private DelimitterCalculator delimitterCalculator;

    @BeforeEach
    public void initialisation() {
        delimitterCalculator = new DelimitterCalculator();
        StringCalculatorKata = new StringCalculatorKata(delimitterCalculator);
    }

    @Test
    public void should_return_zero_when_string_empty() {
        assertEquals(0,StringCalculatorKata.add(""));

    }
    @Test
    public void sum_should_equal_itsself_when_string_single_number() {
        assertEquals(1,StringCalculatorKata.add("1"));

    }

    @Test
    public void should_return_sum_of_numbers_in_String() {
        assertEquals(3,StringCalculatorKata.add("1,2"));

    }

    @Test
    void should_throw_exception_string_does_not_respect_the_right_format() {
        Exception exception = assertThrows(BadFormatException.class , () -> {StringCalculatorKata.add("1&;z;2");});
        String expectedMessage = "The given String does not respect the described format";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void sum_should_equals_sum_of_numbers_in_String_when_there_is_more_than_two_numbers() {
        assertEquals(10,StringCalculatorKata.add("1,2,3,4"));

    }

    @Test
    public void should_return_sum_of_numbers_in_String_and_delimitter_is_new_line() {
        assertEquals(3,StringCalculatorKata.add("1\n2"));

    }

    @Test
    public void should_return_sum_of_numbers_in_String_when_there_is_more_than_two_numbers_and_delimitter_is_new_line() {
        assertEquals(10,StringCalculatorKata.add("1\n2\n3\n4"));

    }

    @Test
    void should_throw_exception_string_does_not_respect_the_right_format_when_delimitter_is_new_line() {
        Exception exception = assertThrows(BadFormatException.class , () -> {StringCalculatorKata.add("1,\n");});
        String expectedMessage = "The given String does not respect the described format";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void sum_when_delimitter_is_specified_in_given_string() {

        assertEquals(3,StringCalculatorKata.add("//[;]\n1;2"));
        assertEquals(3,StringCalculatorKata.add("//[*]\n1*2"));
        assertEquals(3,StringCalculatorKata.add("//[|]\n1|2"));
    }

    @Test
    void should_throw_exception_when_delimitter_is_specified_in_given_string_but_string_does_not_respect_the_right_format() {
        Exception exception = assertThrows(BadFormatException.class , () -> {StringCalculatorKata.add("/;\n1;2");});
        String expectedMessage = "The given String does not respect the described format";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void should_throw_exception_when_delimitter_and_given_string_not_consistent() {
        Exception exception = assertThrows(DelimitterException.class , () -> {StringCalculatorKata.add("//[;]");});
        String expectedMessage = "Delimitter is not suitable to split strings";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void should_throw_exception_when_there_is_negative_number_in_the_given_String() {
        Exception exception = assertThrows(NegativeException.class , () -> {StringCalculatorKata.add("//[;]\n1;-2");});
        String expectedMessage = "Negative Number is Found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }



}
