package com.example.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler{

    public ErrorResponse handlerNotFoundException(NotFoundException e, WebRequest req) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
