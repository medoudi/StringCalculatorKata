package com.exalt.company;

import com.exalt.company.exception.StringCalculatorException;
import org.junit.jupiter.api.BeforeEach;
import com.exalt.company.StringCalculatorKata;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorKataTest {

    private StringCalculatorKata StringCalculatorKata;

    @BeforeEach
    public void initialisation() {
        StringCalculatorKata = new StringCalculatorKata();
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
        Exception exception = assertThrows(StringCalculatorException.class , () -> {StringCalculatorKata.add("1&;z;2");});
        String expectedMessage = "The given String does not respect the described format";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }



}
