package com.akbank.userservice.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotDeleted extends RuntimeException{
    public UserNotDeleted(String message) {
        super(message);
    }
}
