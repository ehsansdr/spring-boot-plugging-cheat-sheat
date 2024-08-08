package com.example.demo.Tables;

import java.io.Serializable;

/**
 * A DTO for the {@link Student} entity
 */

/** this DTO created just for transferring from client to saving that in the data base */
public record StudentDto(String firstName,
                         String lastName,
                         String emailId,
                         Long SchoolId) /* implements Serializable */ {
}