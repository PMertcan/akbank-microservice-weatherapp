package com.akbank.userservice.exception.exceptions;

import com.akbank.userservice.exception.base.BaseException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message) {
        super(message);
        log.error("[UserNotFoundException] -> message : {}", message);
    }
}
