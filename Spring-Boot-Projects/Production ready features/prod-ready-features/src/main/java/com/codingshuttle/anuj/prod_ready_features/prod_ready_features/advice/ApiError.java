package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.advice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError
{
    private LocalDateTime timestamp;
    private String message;
    private HttpStatus statusCode;

    public ApiError(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
