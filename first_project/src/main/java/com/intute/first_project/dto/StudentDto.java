package com.intute.first_project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @NotBlank(message = "studentId is required")
    private String studentId;

    @NotBlank(message = "studentName is required")
    private String studentName;

    @NotBlank(message = "address is required")
    private String address;

    private List<String> courseIds;
}

