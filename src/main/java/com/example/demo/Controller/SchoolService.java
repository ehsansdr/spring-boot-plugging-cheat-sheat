package com.example.demo.Controller;

import com.example.demo.DTO.SchoolDTO;
import com.example.demo.Entity.School;
import com.example.demo.Repositry.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private SchoolRepository schoolRepository;
    private SchoolMapper schoolMapper;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public List<SchoolDTO> getSchoolDTOS() {
        return schoolRepository.findAll().stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }

    public SchoolDTO saveSchoolByDto(SchoolDTO schoolDTO) {
        School school = new School();
        school.setName(schoolDTO.name());
        school = schoolRepository.save(school);
        return schoolDTO;
    }
}
