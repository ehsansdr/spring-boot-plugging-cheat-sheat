package com.example.demo.Tables;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Builder/**  don't forget this  */
public class Course {

    @Id
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECALE THAT AS Long ,not long or Integer ,Not int */
            name = "Course_sequence",
            sequenceName = "Course_sequence",
            allocationSize = 1
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "Course_sequence"
    )
    private Long courseId;//
    private String courseTitle;
    private Integer credit;

    public Course(String courseTitle, Integer credit) {
        this.courseTitle = courseTitle;
        this.credit = credit;
    }
}
