package com.example.demo.Service;

import com.example.demo.DTO.StudentDto;
import com.example.demo.DTO.StudentResponseDto;
import com.example.demo.Entity.Student;
import com.example.demo.Repostiory.SchoolRepository;
import com.example.demo.Repostiory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    // todo : do all the business logic and operation to the in the class that related to the service

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentMapper studentMapper;

    public List<StudentResponseDto> findStudentByFirstNameContaining(String name) {
        return studentRepository.findByFirstNameContaining(name)
                .stream() // we make it in to stream ,not list
                // like studentMapper.studentResponseDto(studentRepository.findAll());
                .map(studentMapper::ToStudentResponseDto)
                .collect(Collectors.toList()); // we change it back to the list
    }


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

        return studentMapper.ToStudentResponseDto(student);
    }


    public StudentResponseDto findStudentById(long studentId) {
        //return studentRepository.findById(studentId)
        //        .orElse(new Student()); /** be careful you will get and error in console if you did not have orElse() */

        // we have another option

        return studentRepository.findById(studentId)
                .map(studentMapper::ToStudentResponseDto)// like : studentMapper.studentResponseDto(studentRepository.findById(studentId));
                .orElse(null);// at first I get error the I press alt + enter and then click first option
    }

    public void deleteStudentObjectById(long studentId) {
        studentRepository.deleteById(studentId);

    }

    // my coding
    public List<StudentResponseDto> getStudentResponseInList() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();
        for(Student student : students){
            studentResponseDtos.add(new StudentResponseDto(student.getFirstName(),
                    student.getLastName(),
                    student.getEmailId()));
        }
        return studentResponseDtos;
    }

    // YouTuber coding
    public List<StudentResponseDto> getStudentResponseByUsingStream() {
        return studentRepository.findAll()
                .stream() // we make it in to stream ,not list
                // like studentMapper.studentResponseDto(studentRepository.findAll());
                .map(studentMapper::ToStudentResponseDto)
                .collect(Collectors.toList()); // we change it back to the list
    }

    //**********************************
    public List<StudentResponseDto> findStudentByFirstName(String name) {
        return studentRepository.findByFirstName(name)
                .stream() // we make it in to stream ,not list
                // like studentMapper.studentResponseDto(studentRepository.findAll());
                .map(studentMapper::ToStudentResponseDto)
                .collect(Collectors.toList()); // we change it back to the list
    }
    public List<StudentResponseDto> findStudentByLastName(String name) {
        return studentRepository.findByLastName(name)
                .stream() // we make it in to stream ,not list
                // like studentMapper.studentResponseDto(studentRepository.findAll());
                .map(studentMapper::ToStudentResponseDto)
                .collect(Collectors.toList()); // we change it back to the list
    }

}
