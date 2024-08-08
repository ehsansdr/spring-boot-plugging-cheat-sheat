package com.example.demo.controller;

import com.example.demo.Repostiory.SchoolRepository;
import com.example.demo.Tables.School;
import com.example.demo.Tables.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SchoolController {

    @Autowired
    SchoolRepository schoolRepository;


    @PostMapping("/schools")
    public School schoolSaving(@RequestBody School school){
        return schoolRepository.save(school);
    }

    @GetMapping("/All-schools")
    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    //********************************

    @GetMapping("/All-schools-with")
    ResponseEntity<School> getAllSchoolsWithResponseEntity(){
        Student student = Student.builder()
                .firstName("ali")
                .lastName("ssss")
                .build();

        School school = School.builder()
                .students(List.of(student))
                .build();
        
        return new ResponseEntity<>(school,HttpStatusCode.valueOf(201));
    }


}
