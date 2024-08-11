package com.example.demo.controller;

import com.example.demo.Entity.Student;
import com.example.demo.DTO.StudentDto;
import com.example.demo.DTO.StudentResponseDto;
import com.example.demo.Service.StudentMapper;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public StudentResponseDto savingStudent(@RequestBody StudentDto dto){
        return studentService.saveStudent(dto);
    }

    @GetMapping("/students/{student-id}")
    public Student findById(@PathVariable("student-id") int studentId){
        return studentService.findStudentById(studentId);
    }

    @DeleteMapping("students/{student-id}")
    public void deletingStudent(@PathVariable("student-id") int studentId){
        studentService.deleteStudentObjectById(studentId);
    }


}
