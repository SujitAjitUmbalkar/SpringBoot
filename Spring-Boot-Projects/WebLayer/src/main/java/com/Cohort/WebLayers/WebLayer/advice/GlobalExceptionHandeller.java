package com.Cohort.WebLayers.WebLayer.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
@RestControllerAdvice
public class GlobalExceptionHandeller
{
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> HandleResourceNotFound(NoSuchElementException e)
    {
        return new ResponseEntity<>("THere is no such resource ", HttpStatus.NOT_FOUND);
    }
}
