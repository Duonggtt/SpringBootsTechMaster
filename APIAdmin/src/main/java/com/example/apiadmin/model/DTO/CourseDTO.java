package com.example.apiadmin.model.DTO;

import com.example.apiadmin.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private int id;
    private String name;
    private String desc;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private User user;
}
