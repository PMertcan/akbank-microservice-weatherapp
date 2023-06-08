package com.akbank.userservice.dto.request;

import jakarta.validation.constraints.*;

public record UserUpdateRequest
        (
                @NotEmpty
                @Size(min = 3, message = "{akbank.firstname.size.message}")
                String firstName,

                @Size(min = 3, message = "{akbank.lastname.size.message}")
                String lastName,

                @NotNull(message = "{akbank.username.message}}")
                String userName,

                @NotNull(message = "{akbank.password.message}")
                String password
        ){}