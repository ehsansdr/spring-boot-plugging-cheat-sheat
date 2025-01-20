package com.example.demo.DTO;

import com.example.demo.Entity.Student;

public record StudentDTO(
    String firstName,
    String lastName,
    String email,
    int age,
    Integer schoolId
) {
}
