package com.example.demo.Controller;

import com.example.demo.DTO.SchoolDTO;
import com.example.demo.Entity.School;
import com.example.demo.Repositry.SchoolRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolMapper {
    private SchoolRepository schoolRepository;

    public SchoolMapper(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;

    }

    public SchoolDTO toSchoolDto(School school) {
        return new SchoolDTO(school.getName());
    }

    public List<SchoolDTO> getSchoolDTOS() {
        List<School> schools = schoolRepository.findAll();
        List<SchoolDTO> schoolDTOS = new ArrayList<>();
        for (School school : schools) {
            schoolDTOS.add(toSchoolDto(school));
        }

        return schoolDTOS;
    }



}
