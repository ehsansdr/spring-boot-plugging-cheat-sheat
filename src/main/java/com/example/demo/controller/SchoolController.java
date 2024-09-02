package com.example.demo.controller;

import com.example.demo.Repostiory.SchoolRepository;
import com.example.demo.Entity.School;
import com.example.demo.controller.DTO.mainPorfile.SchoolDto;
import com.example.demo.controller.DTO.mainPorfile.SchoolResponseDto;
import com.example.demo.Service.mainPorfile.SchoolMapper;
import com.example.demo.Service.mainPorfile.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SchoolController {

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    SchoolService schoolService;

    @Autowired
    SchoolMapper schoolMapper;

    @PostMapping("/schools")
    public SchoolDto schoolSaving(@RequestBody SchoolDto schoolDto){
        return schoolService.create(schoolDto);
    }

    @GetMapping("/All-schools")
    public List<SchoolResponseDto> getAllSchools(){
        return schoolService.getSchoolResponseInStream();
    }

    //********************************

    @GetMapping("/All-schools-with")
    ResponseEntity<School> getAllSchoolsWithResponseEntity(){
        return schoolService.getAllSchoolByEntity();
    }

}