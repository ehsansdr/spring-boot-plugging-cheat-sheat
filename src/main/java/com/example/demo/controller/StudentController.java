package com.example.demo.controller;

import com.example.demo.Repostiory.SchoolRepository;
import com.example.demo.Repostiory.StudentRepository;
import com.example.demo.Tables.Student;
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
    public Student savingStudent(@RequestBody Student student){
//        {
//            "firstName" : "ehsan",
//            "lastName" : "sdr",
//            "emailId" : "sehsansdr251@gmail.com" ,
//            "school" : {
//                 "id": 1 // todo : json find by id,we have "id" in school,so just declaring Id enough to find
//                 }
//        }


        student.setEmailId(StudentService.randomString(6) + "@gmail.com");
        studentRepository.save(student);
        return student;
    }


}
