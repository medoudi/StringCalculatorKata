package com.exalt.company;
import com.exalt.company.exception.BadFormatException;
import com.exalt.company.exception.DelimitterException;
import com.exalt.company.exception.NegativeException;
import com.exalt.company.model.SeparatedNumbersAndDelimitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class StringCalculatorKata {
    public static final String DELIMITTER_REGEX = "(,(?!\n))|(\n(?!,))";

   private final DelimitterCalculator delimitterCalculator;

    @Autowired
    public StringCalculatorKata(final DelimitterCalculator delimitterCalculator) {
        this.delimitterCalculator = delimitterCalculator;
    }


    /**
     * method used to sum numbers given in input
     * @param input
     * @return int sum
     */
    int add(String input) {
        if(input.isEmpty()) {
            return 0;
        } else {
            try {
               String[] numbers = input.startsWith("//") ? delimitterCalculator.getNumbers(input) : input.split(DELIMITTER_REGEX);

                IntStream numbersAsStream = verifyAllNumbersArePositive(numbers);
                return numbersAsStream.sum();
            } catch(NumberFormatException exception) {
                throw new BadFormatException("The given String does not respect the described format");
            }
        }
    }

    /**
     *
     * @param numbers
     * @return
     */
    public IntStream verifyAllNumbersArePositive(String[] numbers ) {
        Supplier<IntStream> intStreamSupplier = () -> Arrays.stream(numbers).mapToInt(Integer::parseInt);
        List<Integer> negatives = intStreamSupplier.get().filter(el -> el < 0).boxed().collect(Collectors.toList());
        if(negatives.size() > 0 ) {

            throw new NegativeException("Negatives not allowed "+negatives);
        }
        return intStreamSupplier.get();
    }
}
