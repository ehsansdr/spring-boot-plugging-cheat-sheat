package com.example.demo.DTO;

import java.util.List;

/**
 * A DTO for the {@link School} entity
 */

/** this class just indented to showing and monitoring the class in beautiful way and format */
public record SchoolResponseDto(String name,
                                List<StudentData> students)  {

    public record StudentData(String firstName,
                              String lastName) {
    }
}