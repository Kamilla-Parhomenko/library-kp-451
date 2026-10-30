package com.example.demo.library.exceptions;

public class CantBeNullException extends RuntimeException {
    public CantBeNullException(String message) {
        super(message);
    }
}
