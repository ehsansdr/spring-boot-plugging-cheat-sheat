package com.example.demo.controller;

import com.example.demo.Repostiory.SchoolRepository;
import com.example.demo.Repostiory.StudentRepository;
import com.example.demo.Tables.School;
import com.example.demo.Tables.Student;
import com.example.demo.Tables.StudentDto;
import com.example.demo.Tables.StudentResponseDto;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRepository schoolRepository;


    @PostMapping("/student")
    public StudentResponseDto savingStudent(@RequestBody StudentDto dto){

        // without dto
//        {
//            "firstName" : "ehsan",
//            "lastName" : "sdr",
//            "emailId" : "sehsansdr251@gmail.com" ,
//            "school" : {
//                 "id": 1 // todo : json find by id,we have "id" in school,so just declaring Id enough to find
//                 }
//        }

     //   by DTO
//        {
//            "firstName" : "kamran",
//             "lastName" : "atabaki",
//             "SchoolId" : 4
//        }


        var student = toStudent(dto);
        var savedStudent = studentRepository.save(student);

        return studentResponseDto(student);
    }


    // for getting dta from dto to entity object
    private Student toStudent (StudentDto dto){
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmailId(StudentService.randomString(6) + "@gmail.com");

        var school = new School();
        school.setId(dto.SchoolId()); //just the id of the saved school needed
        student.setSchool(school);

        return student;
    }

    // creating the dto for saving data just to show that in the client
    private StudentResponseDto studentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmailId());

    }

}
