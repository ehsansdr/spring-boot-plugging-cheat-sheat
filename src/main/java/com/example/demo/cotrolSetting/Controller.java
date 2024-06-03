package com.example.demo.cotrolSetting;

import com.example.demo.Repostiory.StudentRepository;
import com.example.demo.Tables.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@RestController
public class Controller {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/d/d/{message}")
    public String postMapping(@PathVariable("message") String massage,
                              @RequestBody String message){

        //System.out.println(order.toString());

        return "you sent " + massage + "\nmessageSent : " + message;
    }

    @PostMapping("/post-order")
    public String postMap(@RequestBody Order order){

        System.out.println("\npostMap called " + "order : " + order.toString() + "\n");
        //System.out.println(order.toString());

        return "order : " + order.toString();
    }
    @PostMapping("/post-Transaction")
    public String postTransaction(@Valid @RequestBody Transaction transaction){

        System.out.println("\npostTransaction called " + "Transaction : " + transaction.toString() + "\n");
        //System.out.println(order.toString());

        return "order : " + transaction.toString();
    }

    //localhost:8080/hello?showMeAllRecordOfStudent-name=paramvalue&showMeAllRecordOfStudent-lastname=value_2
    @PostMapping("/hello")
    public String postTransactionPram(
            @RequestParam("showMeAllRecordOfStudent-name") String userName,
            @RequestParam("showMeAllRecordOfStudent-lastname") String userLastName
            ){
        return "my value = " + userName + "   " + userLastName;
    }

    @GetMapping("/d/d")
    public String getMapping(){
        return "getMapping is called";
    }


    // for exception handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ) {
        /** if you want to manage exception and get message when the bad request happen
         *  this method will send the exact solution in explicit way
         */
        var errors = new HashMap<String,String>(); // first String will hold the field name
                                                   // second String will hold the message name
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/addData")
    public void addData(@Valid @RequestBody Student student){   // @Valid is necessary
        Student students = Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .build();

        studentRepository.save(students);
    }
}
