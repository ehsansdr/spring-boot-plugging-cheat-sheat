package com.example.demo.Tables;


import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
        @NotEmpty               // make sure the name is not null and is not empty
        // @do not forgot @Valid before @RequestBody
        String firstName,

        @NotEmpty               // make sure the name is not null and is not empty
        // @do not forgot @Valid before @RequestBody
        String lastName,

        String email,

        Integer schoolId
) {
}
