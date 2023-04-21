package com.example.apiadmin.Exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
