package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder
public class School {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;

    // this column will not appear in the table
    @OneToMany(mappedBy = "school")
    //for seeing this field in table we use 2 annotation @JsonManagedReference
    @JsonManagedReference // above  the child class(in logical thinking) ,
                          // school is parent of student,List parameter
    List<Student> students;

    public School(Long id) {
        Id = id;
    }
}
