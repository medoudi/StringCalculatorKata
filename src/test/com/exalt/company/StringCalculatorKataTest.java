package com.exalt.company;

import org.junit.jupiter.api.BeforeEach;
import com.exalt.company.StringCalculatorKata;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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



}
