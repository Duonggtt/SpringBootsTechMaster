package com.example.apiadmin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourseReq {
    private int id;
    private String name;
    private String desc;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private User user;
}
