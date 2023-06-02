package com.akbank.cityservice.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityExceptionResponse {
    private LocalDateTime timestamp;
    private String message;
    private int statusCode;
}
