package com.exalt.company;
import com.exalt.company.exception.BadFormatException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StringCalculatorKata {
    public static final String DELIMITTER_REGEX = "(,(?!\n))|(\n(?!,))";

    int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        else {
            try {
                return Arrays.stream(numbers.split(DELIMITTER_REGEX)).mapToInt(Integer::parseInt).sum();
            }
            catch (NumberFormatException exception ) {
                throw new BadFormatException("The given String does not respect the described format");
            }
        }
    }
}
