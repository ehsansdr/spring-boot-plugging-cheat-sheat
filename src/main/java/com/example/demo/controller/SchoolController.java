package com.example.demo.controller;

import com.example.demo.Repostiory.SchoolRepository;
import com.example.demo.Entity.School;
import com.example.demo.DTO.SchoolDto;
import com.example.demo.DTO.SchoolResponseDto;
import com.example.demo.Entity.Student;
import com.example.demo.Service.SchoolMapper;
import com.example.demo.Service.SchoolService;
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

    @Autowired
    SchoolService schoolService;

    @Autowired
    SchoolMapper schoolMapper;



    @PostMapping("/schools")
    public SchoolDto schoolSaving(@RequestBody SchoolDto schoolDto){
        return schoolService.savingSchoolObject(schoolDto);
    }

    @GetMapping("/All-schools")
    public List<SchoolResponseDto> getAllSchools(){
        return schoolService.getSchoolResponseInList();
    }



    //********************************

    @GetMapping("/All-schools-with")
    ResponseEntity<School> getAllSchoolsWithResponseEntity(){
        return schoolService.getAllSchoolByEntity();
    }


}