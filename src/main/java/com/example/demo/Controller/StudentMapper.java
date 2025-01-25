package com.example.demo.Controller;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.DTO.StudentResposeDTO;
import com.example.demo.Entity.School;
import com.example.demo.Entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {


    public StudentResposeDTO getStudentDTO(Student student) {
        return new StudentResposeDTO(student.getFirstName(),
                student.getLastName(),
                student.getEmail());
    }

    public  Student getStudent(StudentDTO studentdto) {
        Student student = new Student();

        student.setFirstName(studentdto.firstName());
        student.setLastName(studentdto.lastName());
        student.setEmail(studentdto.email());
        student.setAge(studentdto.age());

        var school = new School();
        school.setId(studentdto.schoolId());

        student.setSchool(school);
        return student;
    }
}
