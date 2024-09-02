package com.example.demo.Service;

import com.example.demo.controller.DTO.mainPorfile.StudentDto;
import com.example.demo.controller.DTO.mainPorfile.StudentResponseDto;
import com.example.demo.Entity.School;
import com.example.demo.Entity.Student;
import com.example.demo.Repostiory.StudentRepository;
import com.example.demo.Service.mainPorfile.StudentMapper;
import com.example.demo.Service.mainPorfile.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    // which service tha we want to test
    @InjectMocks // we inject the @Mock annotated attribute in this class
    //and this annotation will go and find the @Mock annotated object in the test class
    private StudentService studentService; // in the StudentService we have two fields(dependency) ,so we need to inject them here

    // declare dependencies (the field that we have in the SchoolService)
    @Mock // we need the annotation from org.mockito.Mock
    private StudentRepository studentRepository;

    @Mock // we need the annotation from org.mockito.Mock
    private StudentMapper studentMapper;


    // in the class that we use mock framework setUp() is essential
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // for injecting @Mocks it is essential
    }

    @Test
    public void should_successfully_save_student(){
        // given
        StudentDto StudentDto = new StudentDto("ali",
                "sss",
                "ssss@gmail.com",
                1L);

        Student student = Student.builder()
                .firstName("ali")
                .lastName("sss")
                .emailId("ssss@gmail.com")
                .school(School.builder().Id(1L).build())
                .build();

        // mock the calls
        // Mockito. but we create static by selecting the second option by alt + insert
        when(studentMapper.toStudent(StudentDto))
                .thenReturn(student);
        when(studentRepository.save(student))
                .thenReturn(student);

//        // when
        StudentResponseDto StudentResponseDto = studentService.saveStudent(StudentDto);

        System.out.println(StudentResponseDto);
//        // then
//        assertEquals(StudentDto.firstName(), studentService.saveStudent(StudentDto).firstName());
//        assertEquals(StudentDto.lastName(), studentService.saveStudent(StudentDto).lastName());
//        assertEquals(StudentDto.emailId(), studentService.saveStudent(StudentDto).emailId());


        verify(studentMapper,times(1)).toStudent(StudentDto);
        verify(studentRepository,times(1)).save(student);
//        verify(studentMapper,times(1)).toStudent(StudentDto);
    }

    @Test
    public void should_return_all_student(){
        // given
        List<Student> students = new ArrayList<>();
        students.add(new Student("John",
                "Doe",
                "john@mail.com",
                new School(2L)
        ));
        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();
        students.add(new Student("John",
                "Doeeeee",
                "john@mail.com",
                new School(2L)
        ));

        // mock
        when(studentRepository.findAll()).thenReturn(students);
//        when(studentService.findAllStudents()).thenReturn(studentResponseDtos);
        when(studentMapper.toStudentResponseDto(any(Student.class))) // passing any object from Student.class we want to return:
                .thenReturn(new StudentResponseDto("John",
                        "D;;;;oe",
                        "john@mail.com"
                ));

        // when
        List<StudentResponseDto> responseDtos = studentService.findAllStudents();
        studentService.findAllStudents();
        System.out.println("students.get(1) : " + students.get(1));
        System.out.println("responseDtos : " + responseDtos);
        System.out.println(studentMapper.toStudentResponseDto(students.get(1)));

        // then
        assertEquals(students.size(),responseDtos.size());

        verify(studentRepository,times(2)).findAll();

    }

    @Test
    public void should_return_student_by_id(){
        // given
        Student studentId123 = Student.builder()
                .id(123L)
                .firstName("123")
                .lastName("1234")
                .emailId("1234@gmail.com")
                .build();

        // mock
        // when(studentRepository.findById(anyLong())).thenReturn(Optional.of(studentId123));
        when(studentRepository.findById(5L)).thenReturn(Optional.of(studentId123));
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(
                new StudentResponseDto("123",
                        "1234",
                        "1234@gmail.com")
        );

        // when

        StudentResponseDto student = studentService.findStudentById(5L);
        // Student student = studentRepository.findById(123L).get();


        // then
        System.out.println("studentRepository.findById(anyLong() : " + studentRepository.findById(5L));
        //assertEquals(studentId123,studentRepository.findById(3L).get().getFirstName());
        assertEquals(studentId123.getFirstName(),student.firstName());
        assertEquals(studentId123.getLastName(),student.lastName());
        assertEquals(studentId123.getEmailId(),student.emailId());


        // in assertEqual() we execute many times
        verify(studentRepository,times(2)).findById(anyLong());

    }

    @Test
    public void find_by_name_testing_youtube_created_test_method(){
        // given
        String studentName = "john";
        List<Student> students = new ArrayList<>();
        students.add(new Student("John",
                "Doe",
                "john@mail.com",
                new School(2L)
        ));

        // when

        when(studentRepository.findByFirstName(studentName)).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(
                new StudentResponseDto(
                        "John",
                        "Doe",
                        "john@mail.com"
                ));

        // var can also save list of object
        var studentResponseDtos = studentService.findStudentByFirstName("john");

        System.out.println("\n\nstudentResponseDtos : " + studentResponseDtos + "\n");

        // then
        assertEquals(studentResponseDtos.size(),students.size());

        verify(studentRepository,times(1)).findByFirstName(studentName);
    }


    @Test
    public void find_by_name_testing_self_created_test_method(){
        // given
        List<Student> students = new ArrayList<>();
        students.add(new Student("John",
                "Doe",
                "john@mail.com",
                new School(2L)
        ));
        students.add(new Student("John",
                "dddd",
                "johndddd@mail.com",
                new School(2L)
        ));

        // when

        when(studentRepository.findByFirstName("john")).thenReturn(students);
        when(studentMapper.toStudentResponseDto(students.get(0))).thenReturn(
                new StudentResponseDto(
                        "John",
                        "Doe",
                        "john@mail.com"
        ));
        when(studentMapper.toStudentResponseDto(students.get(1))).thenReturn(
                new StudentResponseDto("John",
                        "dddd",
                        "johndddd@mail.com"

        ));

        List<StudentResponseDto> studentResponseDtos = studentService.findStudentByFirstName("john");

        System.out.println("\n\nstudentResponseDtos : " + studentResponseDtos + "\n");

        // then
        assertEquals(studentResponseDtos.size(),students.size());

        verify(studentRepository,times(1)).findByFirstName(anyString());
    }

    @Test
    public void delete_testing_self_created_test_method(){
        // given
        long studentID = 1 ;
        Student student = new Student("John",
                "Doe",
                "john@mail.com",
                new School(2L));


        // when
        when(studentRepository.findById(studentID)).thenReturn(Optional.of(student));
        // then
        System.out.println("\n\n" + studentRepository.findById(studentID));
        studentRepository.deleteById(studentID);
        System.out.println("\n\n" + studentRepository.findById(studentID));


    }

    // ********************************************





}