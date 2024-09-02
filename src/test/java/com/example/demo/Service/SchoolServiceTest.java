package com.example.demo.Service;

import com.example.demo.Repostiory.StudentRepository;
import com.example.demo.Service.mainPorfile.StudentMapper;
import com.example.demo.Service.mainPorfile.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class SchoolServiceTest {

    // which service tha we want to test
    @InjectMocks // we inject the @Mock annotated attribute in this class
    private StudentService studentService; // in the StudentService we have two fields(dependency) ,so we need to inject them here

    // declare dependencies (the field that we have in the SchoolService)
    @Mock // we need the annotation from org.mockito.Mock
    private StudentRepository studentRepository;

    @Mock // we need the annotation from org.mockito.Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
    }
}