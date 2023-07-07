package com.example.usermanag2.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public record UpdateUserRequest(@NotEmpty(message = "Name is required")
                                String name,
                                String phone,
                                @NotEmpty(message = "Email is required")
                                @Email
                                String email
) { }