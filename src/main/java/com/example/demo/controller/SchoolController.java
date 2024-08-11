package com.example.demo.controller;

import com.example.demo.Repostiory.SchoolRepository;
import com.example.demo.Entity.School;
import com.example.demo.DTO.SchoolDto;
import com.example.demo.DTO.SchoolResponseDto;
import com.example.demo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            schoolsRepDto.add(new SchoolResponseDto(school.getName(),toStudentData(school.getStudents())));
        }

        return schoolsRepDto;
    }

    private SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }

    @GetMapping("/schools2")
    private List<SchoolDto> findAll(){
        return schoolRepository.findAll() // return the list of the school
                .stream()  // transform the list to the stream
                .map(this::toSchoolDto) // transformation of the object , for each element of the school
                // we can perform the transformation and it will call toSchoolDto()
                // it will call the "stream" of the schoolDto not the "List"
                .collect(Collectors.toList()); // and this method collect the stream as list
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
