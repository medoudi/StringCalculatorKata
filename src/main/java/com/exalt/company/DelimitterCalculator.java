package com.exalt.company;

import com.exalt.company.exception.DelimitterException;
import com.exalt.company.model.SeparatedNumbersAndDelimitter;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class DelimitterCalculator {
    public final static String INPUT_WITH_DELIMITTER_REGEX = "//\\[(.+?)\\]+\n(.*)";

    /**
     * method used to separate delimitter used to get an array from string of numbers
     * @param inputWithDelimitter
     * @return
     */
    SeparatedNumbersAndDelimitter seperateDelimitterFromString(String inputWithDelimitter) {
        SeparatedNumbersAndDelimitter separatedNumbersAndDelimitter = new SeparatedNumbersAndDelimitter("", "");
        Matcher matcher = Pattern.compile(INPUT_WITH_DELIMITTER_REGEX).matcher(inputWithDelimitter);
        if(matcher.matches()) {
            try {
                separatedNumbersAndDelimitter.setDelimitter(Pattern.quote(matcher.group(1)));
                separatedNumbersAndDelimitter.setNumbers(matcher.group(2));
            }
            catch(IllegalStateException | IndexOutOfBoundsException exp) {
                throw new DelimitterException("Delimitter is not suitable to split strings");
            }
        }
        return separatedNumbersAndDelimitter;
    }

    /**
     * method used to extract numbers from input
     * @param input
     * @return
     */
    String[] getNumbers(String input) {
        SeparatedNumbersAndDelimitter separatedNumbersAndDelimitter = seperateDelimitterFromString(input);
        String numbers = separatedNumbersAndDelimitter.getNumbers();
        String delimitter = separatedNumbersAndDelimitter.getDelimitter();
        if(!numbers.isEmpty() && !delimitter.isEmpty())
            return numbers.split(delimitter);
        else {
            throw new DelimitterException("Delimitter is not suitable to split strings");        }

    }

}
