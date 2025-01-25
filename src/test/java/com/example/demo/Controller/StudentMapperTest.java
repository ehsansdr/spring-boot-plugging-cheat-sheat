package com.example.demo.Controller;

import com.example.demo.DTO.SchoolDTO;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.Entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        this.studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        // given
        StudentDTO dto = new StudentDTO("john",
                "Doe",
                "john@mail.com",
                15,
                1);

        // when
        Student student = studentMapper.toStudent(dto);


        // then
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
    }

    @Test
    public void test_null_sending() {
        assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
    }
    @Test
    public void test_not_null_message_sending() {
        var msg = assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
       assertEquals("because \"studentdto\" is null",msg.getMessage());
    }

    public void  throwException() {
        throw new NullPointerException();
    }
    public void  throwRuntimeException() {
        throw new RuntimeException();
    }

    @Test
    public void  throwException2() {
        assertThrows(RuntimeException.class, () -> throwRuntimeException());
    }

    @Test
    public void  assertWithMessag() {
        assertEquals(5,8,"no  they are not  equal"); // when test fail it shows the massage
    }

}