package com.Cohort.WebLayers.WebLayer.advice;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data           //  in short: @Data = @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
@Builder  // @Builder is a Lombok annotation that implements the Builder design pattern,
                // allowing you to create objects step by step in a clean and readable way without writing boilerplate code.
public class ApiError
{
    private HttpStatus status;
    private String message;

}
