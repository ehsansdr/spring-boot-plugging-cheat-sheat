package com.example.demo.Entity.mainPorfile.controller;

import com.example.demo.Repostiory.StudentRepository;
import com.example.demo.Entity.Student;
import com.example.demo.Service.mainPorfile.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceTest {

    // https://www.baeldung.com/mockito-annotations

    // which service that we want to test

    @InjectMocks // this object try to find @Mock annotated objects
    @Autowired
    private StudentService studentService;

    @Mock
    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        /** essential */
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void mockito_testing(){
        Student student = Student.builder()
                .firstName("mahamood")
                .lastName("mahmoodi")
                .build();

        Mockito.when(studentRepository.save(student))
                .thenReturn(student);
    }


    @Test
    public void should_successfully_save_a_student(){
        // given
        Student student = Student.builder()
                .firstName("ss")
                .build();
        Student student1 = Student.builder()
                .firstName("sss")
                .build();

        try{
            if (student.getEmailId() == null){
                throw new NullPointerException("heeeeeyyyy man");
            }
        }catch (NullPointerException e){
            System.out.println("heeeeeyyyy man");
        }catch (Exception e){
            System.out.println("catch block");
        }


        System.out.println("dddddddddddddddddddddd");

        //assertEquals(student.getFirstName(),student1.getFirstName());
        assertNotNull(student.getFirstName()); // if you want to know the field is null or not

    }
}