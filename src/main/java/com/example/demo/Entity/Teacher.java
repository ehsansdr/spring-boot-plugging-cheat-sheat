package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Teacher {

    @Id
    @GeneratedValue
    private Long teacherId;

    private String teacherFirstName;
    private String teacherLastName;
    private String teacherEmailId;

}
