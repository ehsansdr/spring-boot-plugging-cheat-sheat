package com.example.demo.repostiory;

import com.example.demo.Tables.Course;
import com.example.demo.Tables.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveAllCourse(){
        Course course = Course.builder()
                .courseTitle("pathon")
                .credit(8)
                .build();

        courseRepository.save(course);


        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println("course = \n\t" + course + "\nADDED");
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }


    @Test
    public void printAllCourse(){
        List<Course> courses = courseRepository.findAll();

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println(courses.toString());
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }
    @Test
    public void saveCourseWithTeacherObject(){
        Teacher teacher = Teacher.builder()
                .firstName("Ramin")
                .lastName("Khandan")
                .build();

        Course course = Course.builder()
                .courseTitle("dailyCodeBuffer")
                .credit(6)
                .teacher(teacher)
                .build();


        courseRepository.save(course);
    }

}