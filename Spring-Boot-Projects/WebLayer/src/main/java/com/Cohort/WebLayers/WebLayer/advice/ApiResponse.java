package com.Cohort.WebLayers.WebLayer.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({ "timeStamp", "data", "error" })
public class ApiResponse<T>
{
    @JsonFormat(pattern = "hh:mm:ss dd - MM - yyyy")
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
