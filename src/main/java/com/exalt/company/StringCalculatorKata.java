package com.exalt.company;
import com.exalt.company.exception.StringCalculatorException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StringCalculatorKata {

    int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        else {
            try {
                return Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).sum();
            }
            catch (NumberFormatException exception ) {
                throw new StringCalculatorException("The given String does not respect the described format");
            }
        }
    }
}
