package com.Cohort.WebLayers.WebLayer.advice;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({ "timeStamp", "data", "error" })
public class ApiResponse<T>
{
    private LocalDateTime timeStamp;

    private T data;

    private ApiError error;

    public ApiResponse()
    {
        this.timeStamp = LocalDateTime.now();
    }           // automatically added

    public ApiResponse(T data)          // sent from GlobalResponsehandeller
    {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError apiError)           // sent from GlobalExceptionHandeller
    {
        this();
        this.error = apiError;
    }
    // either apiError or Data would be initialised
}
