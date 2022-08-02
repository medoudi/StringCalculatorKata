package com.exalt.company.exception;

/**
 * Exception raised when there is a negative number in the list.
 */
public class NegativeException extends  RuntimeException {

    public NegativeException(String message) {
        super(message);
    }
}
