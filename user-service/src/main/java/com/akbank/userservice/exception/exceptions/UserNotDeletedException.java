package com.akbank.userservice.exception.exceptions;

import com.akbank.userservice.exception.base.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotDeletedException extends BaseException {
    public UserNotDeletedException(String message) {
        super(message);
        log.error("[UserNotDeletedException] -> message : {}", message);
    }
}
