package com.exalt.company.exception;

/**
 * Exception raised when there is problem with delimitter or spliting String using delimitter
 */
public class DelimitterException extends RuntimeException{
    public DelimitterException(String message) {
        super(message);
    }
}
