package com.example.demo.Controller;

import com.example.demo.Entity.School;
import com.example.demo.Repositry.SchoolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolRepository repository;

    public SchoolController(SchoolRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/schools")
    public List<School> getAll() {
        return repository.findAll();
    }
    @PostMapping("/save-school")
    public School saveSchool(@RequestBody School school) {
        return repository.save(school);
    }


}
