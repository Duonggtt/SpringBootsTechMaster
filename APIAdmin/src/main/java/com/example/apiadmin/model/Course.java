package com.example.apiadmin.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private int id;

    @NotNull(message = "Email is required")
    private String name;
    @NotNull(message = "Description is required")
    @Size(min = 51, max = 500, message = "Description must be longer than 50 characters")
    private String desc;
    @NotNull(message = "Type is required")
    private String type;
    private List<String> topics;
    private String thumbnail;
    @NotNull(message = "User is required")
    private User user;
}
