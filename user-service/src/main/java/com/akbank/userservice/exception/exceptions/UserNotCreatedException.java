package com.akbank.userservice.exception.exceptions;

import com.akbank.userservice.exception.base.BaseException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserNotCreatedException extends BaseException {

    public UserNotCreatedException(String message) {
        super(message);
        log.error("[UserNotCreatedException] -> message : {}", message);
    }
}
