package com.akbank.userservice.dto.request;

public record UserUpdateRequest
        (
                String firstName,
                String lastName,
                String userName,
                String password
        ){}