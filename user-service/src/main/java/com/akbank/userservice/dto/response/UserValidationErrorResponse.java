package com.akbank.userservice.dto.response;

import lombok.*;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class UserValidationErrorResponse extends UserExceptionResponse{

    private Map<String, String> validationErrors;

    public UserValidationErrorResponse(LocalDateTime timestamp, String message, int statusCode) {
        super(timestamp, message, statusCode);
    }
}
