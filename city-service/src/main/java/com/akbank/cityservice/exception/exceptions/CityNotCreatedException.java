package com.akbank.cityservice.exception.exceptions;

import com.akbank.cityservice.exception.base.BaseException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CityNotCreatedException extends BaseException {
    public CityNotCreatedException(String message) {
        super(message);
        log.error("[CityNotCreatedException] -> message : {}", message);
    }
}
