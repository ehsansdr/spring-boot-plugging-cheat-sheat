package com.example.demo.controller;

import com.example.demo.Entity.Student;
import com.example.demo.DTO.StudentDto;
import com.example.demo.DTO.StudentResponseDto;
import com.example.demo.Service.StudentMapper;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    // my coding
    @GetMapping("/getStudentResponseDtoList")
    public List<StudentResponseDto> getStudentResponseDtoList(){
        return studentService.getStudentResponseInList();
    }

    // the youtuber coding
    @GetMapping("/getStudentResponseDtoByByUsingStream")
    public List<StudentResponseDto> getStudentResponseDtoByStream(){
        return studentService.getStudentResponseByUsingStream();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto findById(@PathVariable("student-id") int studentId){
        return studentService.findStudentById(studentId);
    }

    @DeleteMapping("students/{student-id}")
    public void deletingStudent(@PathVariable("student-id") int studentId){
        studentService.deleteStudentObjectById(studentId);
    }


    @GetMapping("/findStudentByNameContaining/{student-name}")
    public List<StudentResponseDto> findStudentByFirstName(@PathVariable("student-name") String name){
        return studentService.findStudentByFirstNameContaining(name);
    }


}
