package com.example.demo.Tables;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder
/**  don't forget this  */

@Entity
public class CourseMaterial {
    @Id
    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECLARE THAT AS Long ,not long or Integer ,Not int */
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    //using created sequence
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false//whenever you want to declare record (related field) required
            //and sereneness to declare
            /** it forces us to add*/
    )
    @JoinColumn(/** if you want to link the column of this class to another class column have this  */
            name = "course_id",//it is optional what you want to name that
            // and the// below column name will be change to this
            referencedColumnName = "courseId"//use the real one of the filed name or column name it is linked to the
            //another table column
            //if ypu clicked on this culomn you will get to the Course record to another and the column in this
            // table will get value from upper column from beneath table
            //
    )
    private Course course;

    public CourseMaterial(String url, Course course) {
        this.url = url;
        this.course = course;
    }
}
