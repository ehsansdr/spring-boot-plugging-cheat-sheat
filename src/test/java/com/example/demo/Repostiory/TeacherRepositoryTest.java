package com.example.demo.Repostiory;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test//if you set this as private you can't run this and button will not appear
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .courseTitle("JavaScript")
                .credit(5)
                .build();

        Course courseNBA = Course.builder()
                .courseTitle("Php")
                .credit(5)
                .build();

        Course courseMIT = Course.builder()
                .courseTitle("go")
                .credit(5)
                .build();


        Teacher teacher = Teacher.builder()
                .firstName("Aham")
                .lastName("Rajabi")
                //.course(List.of(courseDBA,courseNBA,courseMIT))
                .build();

        teacherRepository.save(teacher);
    }

}