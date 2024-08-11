package com.example.demo.Service;

import com.example.demo.DTO.StudentDto;
import com.example.demo.DTO.StudentResponseDto;
import com.example.demo.Entity.Student;
import com.example.demo.Repostiory.SchoolRepository;
import com.example.demo.Repostiory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentMapper studentMapper;


    public StudentResponseDto saveStudent(StudentDto dto) {
        // without dto
//        {
//            "firstName" : "ehsan",
//            "lastName" : "sdr",
//            "emailId" : "sehsansdr251@gmail.com" ,
//            "school" : {
//                 "id": 1 // todo : json find by id,we have "id" in school,so just declaring Id enough to find
//                 }
//        }

        //   by DTO
//        {
//            "firstName" : "kamran",
//             "lastName" : "atabaki",
//             "SchoolId" : 4
//        }

        /** first we save the school then we add student to the saved school */
        var student = studentMapper.toStudent(dto);
        var savedStudent = studentRepository.save(student);

        return studentMapper.studentResponseDto(student);
    }


    public Student findStudentById(long studentId) {
        return studentRepository.findById(studentId)
                .orElse(new Student()); /** be careful you will get and error in console if you did not have orElse() */
    }

    public void deleteStudentObjectById(long studentId) {
        studentRepository.deleteById(studentId);

    }
}
