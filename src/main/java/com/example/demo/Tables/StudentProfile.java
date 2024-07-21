package com.example.demo.Tables;

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
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer Id;
    private String Bio;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
