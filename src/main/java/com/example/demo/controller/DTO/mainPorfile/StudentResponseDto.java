package com.example.demo.controller.DTO.mainPorfile;

/**
 * A DTO for the {@link Student} entity
 */

/** this dto just created for only return and monitor the data */
public record StudentResponseDto(String firstName,
                                 String lastName,
                                 String emailId) /* implements Serializable */ {
}