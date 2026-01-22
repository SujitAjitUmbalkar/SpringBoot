package com.Cohort.WebLayers.WebLayer.advice;

import org.jspecify.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class GlobalResponseHandeller implements ResponseBodyAdvice<Object>
{
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public @Nullable Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response)
    {
        if(body instanceof ResponseEntity<?>)
        {
            return body;
        }
        return new ApiResponse<>(body);         // either dto or exception is passed to ApiResponse
    }
}

/*
 **Notes on `if–else` condition execution in `beforeBodyWrite()`:**

 * The `if` condition executes **only when** Spring passes a `ResponseEntity` object directly to `beforeBodyWrite()`.
 * This happens mainly for **exception-handler responses**, where Spring treats the `ResponseEntity` as a complete, final response.
 * When the `if` condition executes, the response is returned **as-is**, and no additional wrapping is done.
 * The `else` condition executes when Spring passes a **raw response body** (DTO, list, string, etc.) to `beforeBodyWrite()`.
 * This occurs for **successful controller responses**, even if the controller originally returned `ResponseEntity<DTO>`.
 * When the `else` condition executes, the response body is wrapped inside `ApiResponse` for consistency.
 * This logic ensures **error responses are not double-wrapped** and **successful responses always follow a standard format**.

 */
