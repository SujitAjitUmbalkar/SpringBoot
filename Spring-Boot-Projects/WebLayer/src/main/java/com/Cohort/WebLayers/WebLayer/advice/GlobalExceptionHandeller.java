package com.Cohort.WebLayers.WebLayer.advice;

import com.Cohort.WebLayers.WebLayer.Exceptions.NoResourceFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeller
{
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiError> HandleResourceNotFound(NoResourceFoundException eobj)
    {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(eobj.getMessage())
                .build();

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
