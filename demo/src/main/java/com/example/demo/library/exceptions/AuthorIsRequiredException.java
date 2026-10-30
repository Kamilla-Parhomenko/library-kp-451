package com.example.demo.library.exceptions;

public class AuthorIsRequiredException extends RuntimeException {
    public AuthorIsRequiredException(String message) {
        super(message);
    }
}
