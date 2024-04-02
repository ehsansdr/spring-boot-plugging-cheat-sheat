package com.example.demo.Tables;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(//if you want to have some unique for column do this
                name = "emailId_unique",
                columnNames = "email_Address"//the name of the column the real one
        )
)//NOT CHANGE THE PAST TABLE ,CREATE NEW AND DO NOTHING ABOUT PREVIOUS TABLE


@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder/**  don't forget this  */
public class Student {

    @Id
    //how we can use sequence for generating automatically fo MYSQL (NOT ORACLE OR POSTGRES)
    //generating but not using that
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    //@Column(name = "email_Address")
    //or
    @Column(/** if you do not have @Table annotation you get bean exception */
            name = "email_Address",
            nullable = false//it means showMeAllRecordOfStudent can leave this empty
    )
    private String emailId;

    @Embedded
    private Guardian guardian;



}
