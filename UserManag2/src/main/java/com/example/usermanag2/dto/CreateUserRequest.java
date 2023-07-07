package com.example.usermanag2.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public record CreateUserRequest(@NotEmpty(message = "Name is required")
                                String name,
                                String phone,
                                @NotEmpty(message = "Email is required")
                                @Email
                                String email,
                                String avatar,
                                @NotEmpty(message = "Password is required")
                                String password
) { }
