# String Calculator Kata

## Environment
- [ ] Java 8+
- [ ] Maven 3
- [ ] Junit 5


## Description
StringCalculatorKata is a project used to sum all the numbers
in a given String.This project is developed by following the steps
described below 


### Step 1
The  first implementation of:

```
 int add(String numbers)
```
The method can take up to two numbers, separated by commas, and will return their sum.

For example “” or “1” or “1,2” as inputs.

For an empty string it will return 0.

### Step 2

The Add method should handle an unknown amount of numbers.

### Step 3

The "add" method should handle new lines between numbers (instead of commas):


### Step 4
Support different delimiters:

- To change a delimiter, the beginning of the string will contain a separate line that looks like this: “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’.
- The first line is optional. All existing scenarios should still be supported.

### Step 5
Calling "add" with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.
If there are multiple negatives, show all of them in the exception message.
