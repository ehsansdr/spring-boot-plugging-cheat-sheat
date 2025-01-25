package com.example.demo.Controller;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.DTO.StudentResposeDTO;
import com.example.demo.Entity.Order;
import com.example.demo.DTO.OrderRecord;
import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
public class FirstController {


    private StudentMapper studentMapper;
    
    private StudentService studentService;
    
    private static final Logger LOGGER = Logger.getLogger(FirstController.class.getName());

    public FirstController(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("FirstController.class sayHello() GET /hello");
        return "Hello form y first controller";
    }


    @GetMapping("/hello2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2() {
        LOGGER.info("FirstController.class sayHello2() GET /hello2");
        return "Hello2 form y first controller";
    }


    @PostMapping("/post")
    public String sayHello3(@RequestBody String message) {
        LOGGER.info("FirstController.class sayHello3 POST /post");
        return "request accepted and the message is " + message;
    }
    @PostMapping("/post-order")
    public String sayHello4(@RequestBody Order order) {
        LOGGER.info("FirstController.class sayHello4 POST /post-order");
        return "request accepted and the message is " + order.toString();
    }

    @PostMapping("/pst-order-record")
    public String postRecord(@RequestBody OrderRecord order) {
        return "request accepted and the order is " + order.toString();
    }

    @GetMapping("/responce-entity")
    public ResponseEntity<String> sayHello5() {
        return new ResponseEntity<>("Hello form y first controller", HttpStatus.CREATED);
    }

    @GetMapping("/responce-entity-header")
    public ResponseEntity<String> sayHello9() {
        String message = "this request must have header and status and body";
        HttpHeaders headers = new HttpHeaders();
        headers.add("1st pram", "2nd pram");// key - value

        return new ResponseEntity<>(message,headers, HttpStatus.CREATED);
    }

    @GetMapping("/is-success")
    public ResponseEntity<String> sayHello10(@RequestParam boolean isSuccess) {
        LOGGER.info("FirstController.class sayHello10() GET /is-success");
        if (isSuccess) {
            return new ResponseEntity<>("Request is successful", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Request is not successful", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/hello/{userName}")
    public String pathVar(@PathVariable String userName) {
        LOGGER.info("FirstController.class pathVar() GET /pathVar");
        return "path varible is this : " + userName;
    }
    @GetMapping("/send_param")
    public String paramVar(
            @RequestParam("user-name") String userName,
            @RequestParam("user-last-name") String userLastName) {
        LOGGER.info("FirstController.class pathVar() GET /paramVar");
        return "path varible is this : " + userName + " " + userLastName;
    }

    @PostMapping("/save-student")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PostMapping("/save-student-dto")
    public Student saveStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return studentService.save(studentMapper.toStudent(studentDTO));
    }
    

    @GetMapping("/student")
    public List<Student> findAll() {
        return studentService.getStudents();
    }

    

    @GetMapping("/student-by-id")
    public Student findStudentById(@RequestParam int id) {
        return studentService.getStudent(id);
    }

    

    @GetMapping("/student-by-name")
    public List<Student> findStudentByFirstName(@RequestParam String letter) {
        return studentService.getStudents(letter);
    }

    

    @GetMapping("/delete-student")
    public void deleteStudentByFirstName(@RequestParam int id) {
        studentService.deleteById(id);
    }



//    @PostMapping("/save-student-dto")
//    public Student saveStudentDTO(@RequestBody StudentDTO studentdto) {
//        Student student = new Student();
//
//        student.setFirstName(studentdto.firstName());
//        student.setLastName(studentdto.lastName());
//        student.setEmail(studentdto.email());
//        student.setAge(studentdto.age());
//
//        School school = schoolrepository.findById(studentdto.schoolId()).get();
//        student.setSchool(school);
//
//        return studentRepository.save(student);
//    }

    // when the upper method get the id of not existed school it sent this exception
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found: " + ex.getMessage());
    }

    @PostMapping("/save-student-dto-2")
    public StudentResposeDTO saveStudentDTO2(@RequestBody StudentDTO studentdto) {
        return studentService.getStudentResposeDTO(studentdto);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String errorMessage = "Data integrity violation occurred.";

        // you can set anouther if to transfer anouthe error essge by like

        if (ex.getMessage().contains("is not present in table \"school\"")) {
            errorMessage = " your given school id is not present in table \"school\"";
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }




//    @GetMapping("/is-success-2")
//    public ResponseEntity<String> sayHello11(@RequestBody Boolean isSucess) {
//        return getStringResponseEntity(isSucess);
//    }

    

    @PostMapping("/receiveJson")
    public String receiveJsonData(@RequestBody String json) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();

        /* -- allowed json
            {
              "name": "John Doe",
              "age": 30
            }
         */

        /* -- not allowed json
            alo
         */

        // Parse the JSON string into a Map
        Map<String, Object> jsonData = objectMapper.readValue(json, HashMap.class);

        // Access data from the map
        String name = (String) jsonData.get("name"); // the part in left side of the json
        int age = (Integer) jsonData.get("age"); // the part in left side of the json
        int age2 = (Integer) jsonData.get("age2"); // the part in left side of the json
        /*
        {
            "name": "John Doe",
                "age": 30 ,
                "age2" : 58
        }
        */
        // if oy sent non of them but want ti extract data from them in java you will get
        // exceptipn

        // Process the data (example)
        String response = "Received data: name=" + name + ", age=" + age + ", age2=" + age2;

        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        var errors = new HashMap<String,String>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            String field = error.getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


}
