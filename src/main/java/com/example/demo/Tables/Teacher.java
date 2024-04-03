package com.example.demo.Tables;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Teacher {

    @Id
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECALE THAT AS Long ,not long or Integer ,Not int */
            name = "Teacher_sequence",
            sequenceName = "Teacher_sequence",
            allocationSize = 1
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "Teacher_sequence"
    )
    private Long TeacherId;
    private String firstName;
    private String lastName;

//    @OneToMany(//uni directional on to
//        cascade = CascadeType.ALL  //when ever you are saving new record
//            // all the things save
//            //fetch = FetchType.LAZY  //be careful about this
//    )
//    @JoinColumn(//if you want to link to secrete table to rwo column di this
//            name = "Teacher_Id",//
//
//            /**  bug */
//            referencedColumnName = "TeacherId"//another table column
//            //if ypu clicked on this column you will get to the Course record to another and the column in this
//            // table will get value from upper column from beneath table
//            //
//    )
//    private List<Course> course;//because one teacher can have multiple course
}
