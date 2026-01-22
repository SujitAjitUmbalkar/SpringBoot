package com.Cohort.WebLayers.WebLayer.advice;

import com.Cohort.WebLayers.WebLayer.Exceptions.NoResourceFoundException;
import jakarta.persistence.ElementCollection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandeller
{
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiResponse<?>> HandleResourceNotFound(NoResourceFoundException eobj)
    {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(eobj.getMessage())
                .build();

        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<ApiResponse<?>> HandleInternalServerError(Exception eobj)
    {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(eobj.getMessage())
                .build();

         return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>>  HandleInputValidation(MethodArgumentNotValidException eobj)
    {
        List<String> errors = eobj
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error ->error.getDefaultMessage())
                .collect(Collectors.toList());

                ApiError apiError = ApiError.builder()
                        .status(HttpStatus.BAD_REQUEST)
//                        .message(errors.toString())
                        .message("Input Validation Failed")
                        .subErrors(errors)
                        .build();
        return buildErrorResponseEntity(apiError);
    }

    ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError)
    {
        return new  ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }
    // This method is used to **create and return a standardized error response** by wrapping an `ApiError` inside `ApiResponse` and sending it with the appropriate HTTP status code.

}
