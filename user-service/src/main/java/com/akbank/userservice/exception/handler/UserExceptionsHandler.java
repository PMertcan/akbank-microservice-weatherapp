package com.akbank.userservice.exception.handler;

import com.akbank.userservice.dto.response.UserExceptionResponse;
import com.akbank.userservice.dto.response.UserValidationErrorResponse;
import com.akbank.userservice.exception.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserExceptionsHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public UserExceptionResponse handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        return userExceptionParser(LocalDateTime.now(), userNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(UserNotCreatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UserExceptionResponse handleUserNotCreatedException(UserNotCreatedException userNotCreatedException) {
        return userExceptionParser(LocalDateTime.now(), userNotCreatedException.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(UserNotUpdatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UserExceptionResponse handleUserNotUpdatedException(UserNotUpdatedException userNotUpdatedException) {
        return userExceptionParser(LocalDateTime.now(), userNotUpdatedException.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(UserNotDeletedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UserExceptionResponse handleUserNotDeletedException(UserNotDeletedException userNotDeletedException) {
        return userExceptionParser(LocalDateTime.now(), userNotDeletedException.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private UserValidationErrorResponse handleValidationException(MethodArgumentNotValidException exception) {
        UserValidationErrorResponse error = new UserValidationErrorResponse(LocalDateTime.now(), "Validation Error", HttpStatus.BAD_REQUEST.value());
        Map<String, String> validationErrors = new HashMap<>();
        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        error.setValidationErrors(validationErrors);
        return error;
    }

    private UserExceptionResponse userExceptionParser(LocalDateTime localDateTime, String message, int statusCode) {
        return UserExceptionResponse.builder()
                .timestamp(localDateTime)
                .message(message)
                .statusCode(statusCode)
                .build();
    }
}
