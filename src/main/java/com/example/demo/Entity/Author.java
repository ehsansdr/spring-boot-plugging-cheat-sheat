package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Profile;

import java.lang.annotation.Target;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "AUTHOR_TBL")
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            name = "f_name"
    )
    private String firstName;

    private String lastName;

    @Column(
            unique = true ,
            nullable = false
    )
    private String emailId;
    private int age;

    @Column(
            insertable = false,
            nullable = false
    )
    private LocalDateTime createdAT;

    @Column(
            insertable = false
    )
    private LocalDateTime lastModified;

}
