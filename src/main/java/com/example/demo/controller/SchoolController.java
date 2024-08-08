package com.example.demo.controller;

import com.example.demo.Repostiory.SchoolRepository;
import com.example.demo.Tables.School;
import com.example.demo.Tables.SchoolDto;
import com.example.demo.Tables.SchoolResponseDto;
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
    public SchoolDto schoolSaving(@RequestBody SchoolDto schoolDto){
        School school = toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    // getting data from dto to the school entity  object
    private School toSchool(SchoolDto schoolDto) {
        var school = School.builder()
                .name(schoolDto.name())
                .build();

        return school;
    }

    @GetMapping("/All-schools")
    public List<SchoolResponseDto> getAllSchools(){
        List<School> schools = schoolRepository.findAll();
        List<SchoolResponseDto> schoolsRepDto = new ArrayList<>();

        SchoolResponseDto tempSchool;
        for(School school: schools){
            tempSchool = new SchoolResponseDto(school.getName(),toStudentData(school.getStudents()));
            schoolsRepDto.add(tempSchool);
        }

        return schoolsRepDto;
    }

    private List<SchoolResponseDto.StudentData> toStudentData(List<Student> students){
        List<SchoolResponseDto.StudentData> studentData = new ArrayList<>();

        SchoolResponseDto.StudentData tempStudents;
        for(Student student: students){
            tempStudents = new SchoolResponseDto.StudentData(student.getFirstName(),student.getLastName());
            studentData.add(tempStudents);
        }

        return studentData;
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
