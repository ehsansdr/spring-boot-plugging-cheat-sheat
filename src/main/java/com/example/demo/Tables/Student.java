package com.example.demo.Tables;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String emailId;

    @OneToOne(mappedBy = "student",
        cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private StudentProfile studentProfile;

    @ManyToOne // todo every time you have this ,prepare @JoinColumn
    @JoinColumn(name = "school")
                        // we have this above the parent class in logical thinking student is child of the school
    @JsonBackReference  // this tells that this entity does not need to serialize the parent
    private School school;

//    @OneToOne(mappedBy = "teacherId")
//    private Teacher TeacherName;

}
