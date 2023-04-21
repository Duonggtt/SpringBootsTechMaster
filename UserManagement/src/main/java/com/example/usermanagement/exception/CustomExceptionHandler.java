package com.example.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler{

    public ErrorResponse handlerNotFoundException(NotFoundException e, WebRequest req) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBindException(BindException e) {
        String errorMessage = "Req is not valid. Detail errors:";
        if(e.getBindingResult().hasErrors()) {
            List<String> defaultMessage = e.getBindingResult().getAllErrors().stream().map(err -> err.)
            errorMessage += e.getBindingResult().getAllErrors();

        }
        return new ErrorResponse(HttpStatus.BAD_REQUEST, errorMessage);
    }
}
