package com.example.demo.Tables;

import jakarta.persistence.*;
import lombok.*;


@Entity

@AllArgsConstructor
@NoArgsConstructor
//@Data   /** WEGOT STACK OVERFLOW EXCEPTION IN CourseRepositoryTest BECAUSE OF THIS SO I OMITTED THIS*/
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
    private Long CourseId;//use Long ,not long
    private String courseTitle;
    private Integer credit;

    @OneToOne(//if you don't have this you will
            cascade = CascadeType.ALL//private Course course; in CourseMaterial so we use the object name course
            //fetch = FetchType.LAZY
    )
//    @Column(
//            name = "courseMaterial"
//    )
    private CourseMaterial courseMaterial;


    @ManyToOne(
            cascade = CascadeType.ALL,  //?
            fetch = FetchType.LAZY
    )

//    @Column(
//            name = "teacher Id"
//    )
    private Teacher teacher;


    public Course(String courseTitle, Integer credit) {
        this.courseTitle = courseTitle;
        this.credit = credit;
    }


}
