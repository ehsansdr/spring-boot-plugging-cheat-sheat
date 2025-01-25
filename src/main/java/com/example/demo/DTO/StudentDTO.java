package com.example.demo.DTO;

import com.example.demo.Entity.Student;
import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
    @NotEmpty(message = "firstName can not be empty")
    String firstName,
    @NotEmpty(message = "lastName can not be empty")
    String lastName,
    String email,
    int age,
    Integer schoolId
) {
}
