package com.example.demo.DTO;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * A DTO for the {@link Student} entity
 */

/** this DTO created just for transferring from client to saving that in the data base */
public record StudentDto(
        // todo: do not forget the @Valid before @RequestBody in the controller

        @NotBlank(message = "the first name should not be empty ")
        String firstName,

        @NotBlank(message = "the last name should not be empty ")
        String lastName,

        @Email(message = "you did not type the right E-mail format")
        String emailId,

        Long SchoolId) /* implements Serializable */ {
}