package com.example.demo.Tables;import jakarta.persistence.*;import lombok.*;import java.util.ArrayList;import java.util.List;@Entity@AllArgsConstructor@NoArgsConstructor//@Data   /** WEGOT STACK OVERFLOW EXCEPTION IN CourseRepositoryTest BECAUSE OF THIS SO I OMITTED THIS*/@Builder/**  don't forget this  */public class Course {    @Id    @SequenceGenerator(/** IF YOU WANT TO DO THIS ON FIELD DECALE THAT AS Long ,not long or Integer ,Not int */            name = "Course_sequence",            sequenceName = "Course_sequence",            allocationSize = 1    )    //using created sequence    @GeneratedValue(            strategy =  GenerationType.SEQUENCE,            generator = "Course_sequence"    )    private Long CourseId;//use Long ,not long    private String courseTitle;    private Integer credit;    @OneToOne(//if you don't have this you will            cascade = CascadeType.ALL,//private Course course; in CourseMaterial so we use the object name course            fetch = FetchType.LAZY    )//    @Column(//            name = "courseMaterial"//    )    private CourseMaterial courseMaterial;    @ManyToOne(            cascade = CascadeType.ALL  //when ever you are saving new course and new teacher            //and new course material all the things save//            fetch = FetchType.LAZY    )    @JoinColumn(            name = "Teacher_id",            referencedColumnName = "TeacherId"    )    private Teacher teacher;    @ManyToMany(            cascade = CascadeType.ALL    )    @JoinTable(// 6:45:0 for this tutorial            //this annotation we need to have with colum we have in this table sowe use this pattern            name = "student_course_mapping",//this table would be created            //one of the column that we want to have to this table            joinColumns = @JoinColumn(                    name = "course_id",                    referencedColumnName = "CourseId"//we copy and paste the exact name from the course class field                    //so copy paste the exact name of the field            ),            /** we want to have common and conversely relation between Student and course table so we need             * this pattern : */            inverseJoinColumns = @JoinColumn(                    name = "student_id",                    referencedColumnName = "studentId"//we copy and paste the exact name from the Student class field                    //so copy and paste the exact name of the field            )    )    private List<Student> students = new ArrayList<>();    public void addStudent(Student student){        //we add this method becuase we have @ManyToMany in field for students        if (students == null) {            this.students = new ArrayList<>();            students.add(student);            System.out.println("\nthis.students = new List<>();\n");        }        else{            students.add(student);            System.out.println("\nstudents.add(student);\n");        }    }    public Course(String courseTitle, Integer credit) {        this.courseTitle = courseTitle;        this.credit = credit;    }}