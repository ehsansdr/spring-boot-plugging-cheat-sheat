package com.example.demo.Entity;

import com.example.demo.Controller.StudentProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;
    private int age;

    // cascade means if we delete or remove this object
    // the relation will delete the other side table
    @OneToOne(mappedBy = "student",
            cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    // have this in to your allargs constrictor
    @ManyToOne // may be cascde is not approprate heres
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;

    public Student() {
    }

    public Student(Integer id, String firstName, String lastName, String email, int age,School school) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.school = school;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
