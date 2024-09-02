package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;

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
