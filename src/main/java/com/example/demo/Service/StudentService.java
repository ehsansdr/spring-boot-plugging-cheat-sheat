package com.example.demo.Service;

import com.example.demo.Controller.StudentMapper;
import com.example.demo.DTO.StudentDTO;
import com.example.demo.DTO.StudentResposeDTO;
import com.example.demo.Entity.Student;
import com.example.demo.Repositry.SchoolRepository;
import com.example.demo.Repositry.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private SchoolRepository schoolrepository;
    private StudentMapper studentMapper;
    private static final Logger LOGGER = Logger.getLogger(StudentService.class.getName());

    public StudentService(StudentRepository studentRepository, SchoolRepository schoolrepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.schoolrepository = schoolrepository;
        this.studentMapper = studentMapper;
    }

    public StudentResposeDTO getStudentResposeDTO(StudentDTO studentdto) {
        Student student = studentMapper.toStudent(studentdto);
        studentRepository.save(student);
        return studentMapper.getStudentDTO(student);
    }

    public ResponseEntity<String> getStringResponseEntity(Boolean isSucess) {
        LOGGER.info("FirstController.class sayHello11() GET /is-success-2");

        if (isSucess) {
            return new ResponseEntity<>("Request is successful", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Request is not successful", HttpStatus.BAD_REQUEST);
        }
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id)
                .orElse(new Student());
    }
    public List<Student> getStudents(String letter) {
        return studentRepository.findAllByFirstNameContaining(letter);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public Integer gg(){
        return Integer.valueOf(1);
    }

}
