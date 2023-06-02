package com.akbank.cityservice.exception.handler;

import com.akbank.cityservice.dto.response.CityExceptionResponse;
import com.akbank.cityservice.exception.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CityExceptionsHandler {

    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CityExceptionResponse handleCityNotFoundException(CityNotFoundException cityNotFoundException) {
        return cityExceptionResponseParser(LocalDateTime.now(), cityNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(CityNotCreatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CityExceptionResponse handleCityNotCreatedException(CityNotCreatedException cityNotCreatedException) {
        return cityExceptionResponseParser(LocalDateTime.now(), cityNotCreatedException.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    private CityExceptionResponse cityExceptionResponseParser(LocalDateTime localDateTime, String message, int statusCode) {
        return CityExceptionResponse.builder()
                .timestamp(localDateTime)
                .message(message)
                .statusCode(statusCode)
                .build();
    }
}
