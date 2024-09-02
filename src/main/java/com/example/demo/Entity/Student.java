package com.example.demo.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Entity
@Table(name = "Student")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {

    @Id
    @GeneratedValue
    private Long id;


    private String firstName;
    private String lastName;

//    @Min(1)
//    private int age;

    @Value("${random.uuid}" + "@gmail.com")
    private String emailId;

    @OneToOne(mappedBy = "student",
        cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private StudentProfile studentProfile;

//    @Column(name = "created at",
//        insertable = false
//    )
//    private LocalDateTime timeCreated;


    @ManyToOne // todo every time you have this ,prepare @JoinColumn
    @JoinColumn(name = "school")
    /** the owner of relationship is this so have mappedBy in reverse class and name in this class*/
                        // we have this above the parent class in logical thinking student is child of the school
    @JsonBackReference  // this tells that this entity does not need to serialize the parent
    private School school;

//    @OneToOne(mappedBy = "teacherId")
//    private Teacher TeacherName;


    public Student(String firstName, String lastName, String emailId, School school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.school = school;
    }
}
