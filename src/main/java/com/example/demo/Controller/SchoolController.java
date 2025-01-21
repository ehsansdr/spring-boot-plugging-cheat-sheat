package com.example.demo.Controller;

import com.example.demo.DTO.SchoolDTO;
import com.example.demo.Entity.School;
import com.example.demo.Repositry.SchoolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository repository) {
        this.schoolRepository = repository;
    }

    @GetMapping("/schools")
    public List<School> getAll() {
        return schoolRepository.findAll();
    }
    @PostMapping("/save-school")
    public School saveSchool(@RequestBody School school) {
        return schoolRepository.save(school);
    }


    @GetMapping("/school-dto")
    public List<SchoolDTO> getSchools() {
        List<School> schools = schoolRepository.findAll();
        List<SchoolDTO> schoolDTOS = new ArrayList<>();
        for (School school : schools) {
            schoolDTOS.add(toSchoolDto(school));
        }

        return schoolDTOS;
    }
    @GetMapping("/school-dto-stream")
    public List<SchoolDTO> getSchoolsByStream() {
        return schoolRepository.findAll().stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }

    private SchoolDTO toSchoolDto(School school) {
        return new SchoolDTO(school.getName());
    }


    @PostMapping("/save-school-dto")
    public SchoolDTO saveSchool(@RequestBody SchoolDTO schoolDTO) {
        School school = new School();
        school.setName(schoolDTO.name());
        school = schoolRepository.save(school);
        return schoolDTO;
    }

}
