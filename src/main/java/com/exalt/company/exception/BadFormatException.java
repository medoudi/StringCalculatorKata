package com.exalt.company.exception;

/**
 * Exception raised when String is in badFormat and cannot mapping it to int.
 */
public class BadFormatException extends RuntimeException{
    public BadFormatException(String message) {super(message);}
}
