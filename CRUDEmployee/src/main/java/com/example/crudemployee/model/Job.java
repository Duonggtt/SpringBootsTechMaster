package com.example.crudemployee.model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Job {
    private String name;
    private String detail;
    private String salary;
}
