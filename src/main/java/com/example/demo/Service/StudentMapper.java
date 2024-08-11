package com.example.demo.Service;

import com.example.demo.DTO.StudentDto;
import com.example.demo.DTO.StudentResponseDto;
import com.example.demo.Entity.School;
import com.example.demo.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StudentMapper {

    // todo : if we need new method for mapping or if we need to return from the type to another type or transformation
    //

    // for getting dta from dto to entity object
    public Student toStudent (StudentDto dto){
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmailId(StudentMapper.randomString(6) + "@gmail.com");

        var school = new School();
        school.setId(dto.SchoolId()); //just the id of the saved school needed
        student.setSchool(school);

        return student;
    }

    // creating the dto for saving data just to show that in the client
    public StudentResponseDto ToStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmailId());

    }

    // *********************************************

    public static String randomString(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }


}
