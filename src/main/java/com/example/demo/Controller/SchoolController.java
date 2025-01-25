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
    private final SchoolService schoolService;
    private final SchoolMapper schoolMapper;

    public SchoolController(SchoolRepository repository,SchoolService schoolService, SchoolMapper mapper) {
        this.schoolRepository = repository;
        this.schoolService = schoolService;
        this.schoolMapper = mapper;
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
        return schoolMapper.getSchoolDTOS();
    }




    @GetMapping("/school-dto-stream")
    public List<SchoolDTO> getSchoolsByStream() {
        return schoolService.getSchoolDTOS();
    }




    @PostMapping("/save-school-dto")
    public SchoolDTO saveSchool(@RequestBody SchoolDTO schoolDTO) {
        return schoolService.saveSchoolByDto(schoolDTO);
    }



}
