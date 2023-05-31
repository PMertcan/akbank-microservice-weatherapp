package com.akbank.userservice.dto.request;

public record UserCreateRequest
        (
                String firstName,
                String lastName,
                String userName,
                String password
        ){}
