package com.akbank.cityservice.exception.exceptions;

import com.akbank.cityservice.exception.base.BaseException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CityNotFoundException extends BaseException {

    public CityNotFoundException(String message) {
        super(message);
        log.error("[CityNotFoundException] -> message : {}", message);
    }
}
