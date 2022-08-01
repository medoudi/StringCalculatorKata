package com.exalt.company;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StringCalculatorKata {

    int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        else {
            return Arrays.stream(numbers.split(",")).mapToInt(Integer ::parseInt).sum();
        }
    }
}
