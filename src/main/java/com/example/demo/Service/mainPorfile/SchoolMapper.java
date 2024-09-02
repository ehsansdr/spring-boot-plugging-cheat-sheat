package com.example.demo.Service.mainPorfile;

import com.example.demo.controller.DTO.mainPorfile.SchoolDto;
import com.example.demo.controller.DTO.mainPorfile.SchoolResponseDto;
import com.example.demo.Entity.School;
import com.example.demo.Entity.Student;
import com.example.demo.Repostiory.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Profile("main")
public class SchoolMapper {
    // todo : if we need new method for mapping or if we need to return from the type to another type or transformation


    @Autowired
    SchoolRepository schoolRepository;


    public School toSchool(SchoolDto schoolDto) {
         return School.builder()
                .name(schoolDto.name())
                .build();

    }

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }

    public SchoolResponseDto toSchoolResponseDto(School school) {
        return new SchoolResponseDto(school.getName(),toStudentData(school.getStudents()));

    }
    private List<SchoolResponseDto.StudentData> toStudentData(List<Student> students) {
        List<SchoolResponseDto.StudentData> studentData = new ArrayList<>();

        SchoolResponseDto.StudentData tempStudents;
        for (Student student : students) {
            tempStudents = new SchoolResponseDto.StudentData(student.getFirstName(), student.getLastName());
            studentData.add(tempStudents);
        }
        return studentData;
    }

    // *********************************************

}
