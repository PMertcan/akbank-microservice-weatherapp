package com.akbank.userservice.dto.response;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserExceptionResponse {
    private LocalDateTime timestamp;
    private String message;
    private int statusCode;
}
