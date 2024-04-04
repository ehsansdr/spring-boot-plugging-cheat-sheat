package com.example.demo.repostiory;

import com.example.demo.Tables.Course;
import com.example.demo.Tables.Guardian;
import com.example.demo.Tables.Student;
import com.example.demo.Tables.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
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

    @Test
    public void findAllPagination(){
        //https://www.baeldung.com/spring-data-jpa-pagination-sorting
        //https://www.javatpoint.com/spring-mvc-pagination-example

        Pageable firstPageWithThreeRecord =
                (Pageable) PageRequest.of(0, 3, Sort.by("credit"));
        Pageable secondPageWithThreeRecord =
                (Pageable) PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll((Sort) firstPageWithThreeRecord);

        //Long totalElement = courseRepository.findAll(firstPageWithThreeRecord);
        //Long totalPages = courseRepository.findAll(firstPageWithThreeRecord);

        //System.out.println("totalPages : " + totalPages);
        //System.out.println("totalElement : " + totalElement);
        System.out.println("courses : " + courses);

    }


    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("mohamad")
                .lastName("sahahee")
                .build();

        Guardian guardian = Guardian.builder()
                .name("hamid jan")
                .email("hamid has email")
                .mobile("23569")
                .build();

        Student student1 = Student.builder()
                .firstName("mmmdrza")
                .lastName("esmailly")
                .emailId("esmaillykd@gmail.com")
                .guardian(guardian)
                .build();

        Course course = Course.builder()//
                .courseTitle("physics")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudent(student1);//create this by your self

        courseRepository.save(course);

        System.out.println("**************************************************");
        System.out.println("--------------------------------------------------");
        System.out.println("course : " + course + "\nADDED");
        System.out.println("--------------------------------------------------");
        System.out.println("**************************************************");
    }


}