package com.example.usermanag2.dto;

import javax.validation.constraints.NotEmpty;

public record UpdateUserAvatarRequest(
        @NotEmpty(message = "Avatar is required")
        String avatar
) {}
