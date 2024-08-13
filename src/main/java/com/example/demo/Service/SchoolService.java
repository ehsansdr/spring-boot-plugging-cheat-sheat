package com.example.demo.Service;

import com.example.demo.DTO.SchoolDto;
import com.example.demo.DTO.SchoolResponseDto;
import com.example.demo.Entity.School;
import com.example.demo.Entity.Student;
import com.example.demo.Repostiory.SchoolRepository;
import com.example.demo.Repostiory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    // todo : do all the business logic and operation to the in the class that related to the service

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private SchoolMapper schoolMapper;


    public SchoolDto create(SchoolDto schoolDto) {
        // this method sent the school after saving that
        schoolRepository.save(schoolMapper.toSchool(schoolDto));
        return schoolDto;
    }


    // my coding
    public List<SchoolResponseDto> getSchoolResponseInStream() {
        return schoolRepository.findAll()
                .stream() // we make it in to stream ,not list
                // like studentMapper.studentResponseDto(studentRepository.findAll());
                .map(schoolMapper::toSchoolResponseDto) // it will do this for each element ,not all element in parameter of the method
                .collect(Collectors.toList());
    }
// it will do those for each element ,not all element in parameter of the method

    // YouTuber coding
    public List<SchoolResponseDto> getSchoolResponseByUsingStream() {
        return schoolRepository.findAll()
                .stream() // we make it in to stream ,not list
                // like studentMapper.studentResponseDto(studentRepository.findAll());
                .map(schoolMapper::toSchoolResponseDto)// it will do this for each element ,not all element in parameter of the method
                .collect(Collectors.toList()); // we change it back to the list
    }



    //**********************************
    public ResponseEntity<School> getAllSchoolByEntity() {
        Student student = Student.builder()
                .firstName("ali")
                .lastName("ssss")
                .build();

        School school = School.builder()
                .students(List.of(student))
                .build();

        return new ResponseEntity<>(school, HttpStatusCode.valueOf(201));
    }

}
