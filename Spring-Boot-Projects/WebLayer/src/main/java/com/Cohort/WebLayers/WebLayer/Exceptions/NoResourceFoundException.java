package com.Cohort.WebLayers.WebLayer.Exceptions;

public class NoResourceFoundException extends RuntimeException
{
    public NoResourceFoundException(String message)
    {
        super(message);
    }
}

/*
        This custom exception is important because it represents application-specific errors clearly,
        improves code readability, avoids using generic Java exceptions,
        helps in sending meaningful error messages to clients,
        enables centralized handling through global exception handlers,
         keeps the project structure clean, and follows industry-standard Spring Boot best practices.
 */