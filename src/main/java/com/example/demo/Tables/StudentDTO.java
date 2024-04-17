package com.example.demo.Tables;


import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
        @NotEmpty               // make sure the name is not null and is not empty
        String firstName,

        @NotEmpty               // make sure the name is not null and is not empty
        String lastName,

        String email,

        Integer schoolId
) {
}
