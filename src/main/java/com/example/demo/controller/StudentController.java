package com.example.demo.controller;

import com.example.demo.controller.DTO.mainPorfile.StudentDto;
import com.example.demo.controller.DTO.mainPorfile.StudentResponseDto;
import com.example.demo.Service.mainPorfile.StudentMapper;
import com.example.demo.Service.mainPorfile.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController

public class StudentController {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public StudentResponseDto savingStudent(@Valid @RequestBody StudentDto dto){
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

    @DeleteMapping("delete_students/{student-id}")
    public void deletingStudent(@PathVariable("student-id") int studentId){
        studentService.deleteStudentObjectById(studentId);
    }


    @GetMapping("/findStudentByNameContaining/{student-name}")
    public List<StudentResponseDto> findStudentByFirstName(@PathVariable("student-name") String name){
        return studentService.findStudentByFirstNameContaining(name);
    }


    /** exception handler part */
    /** so when the MethodArgumentNotValidException will throw or raise in this controller
     * this method will handle the exception and try toe extract and transform the error messages
     * that are coming from validation process and transform them to proper response that we can send to the user
     * if you do not have this you will get the long message that contain the 100 lines and it is hard to find the message*/
    @ExceptionHandler(MethodArgumentNotValidException.class) /** essential */
    public ResponseEntity<?> handleMethodNotValidException( // <?> : means of any type expected
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String,String>(); // first string will hold the field name ,second will hold the message name

        // then we need to get exception (validation exception) from MethodArgumentNotValidException
        // and then transform them and then sent back the map of key and value
        // the key is rhe field and value is the message :

        exp.getBindingResult().getAllErrors() // will return the List<ObjectError>
                .forEach(error -> {
                    var fieldName = (((FieldError)error).getField()); // our exception have this part
                    var errorMessage = error.getDefaultMessage(); // our exception have this part
                    errors.put(fieldName,errorMessage); // store this to the error map
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    // when the column does not exist :
    @ExceptionHandler(InvalidDataAccessResourceUsageException.class) /** essential */
    public ResponseEntity<?> handleInvalidDataAccessResourceUsageException( // <?> : means of any type expected
                          InvalidDataAccessResourceUsageException exp
    ){
        var errors = new HashMap<String,String>(); // first string will hold the field name ,second will hold the message name

        // then we need to get exception (validation exception) from MethodArgumentNotValidException
        // and then transform them and then sent back the map of key and value
        // the key is rhe field and value is the message :

        errors.put(exp.getMessage(),exp.getCause().getLocalizedMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class) /** essential */
    public ResponseEntity<?> handleHttpRequestMethodNotSupportedException( // <?> : means of any type expected
                            HttpRequestMethodNotSupportedException exp
    ){
        var errors = new HashMap<String,String>(); // first string will hold the field name ,second will hold the message name

        // then we need to get exception (validation exception) from MethodArgumentNotValidException
        // and then transform them and then sent back the map of key and value
        // the key is rhe field and value is the message :

        errors.put("the http method does not correct ",exp.getSupportedHttpMethods().toString());
        return new ResponseEntity<>("ggggggggggggggggggggg ", HttpStatus.BAD_REQUEST);
    }

    // HttpRequestMethodNotSupportedException

}
