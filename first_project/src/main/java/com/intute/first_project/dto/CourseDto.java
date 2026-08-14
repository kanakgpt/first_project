package com.intute.first_project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    @NotBlank(message = "courseId is required")
    private String courseId;

    @NotBlank(message = "courseName is required")
    private String courseName;
}

