package com.example.usermanag2.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public record UpdateUserPasswordRequest(
        @NotEmpty(message = "Password is required")
        String oldPassword,
        @NotEmpty(message = "Password is required")
        String newPassword
) { }