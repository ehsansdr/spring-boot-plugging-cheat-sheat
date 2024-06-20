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

import java.util.HashMap;

@RestController
public class Controller {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/d/d/{message2}")
    public String postMapping(@PathVariable String message2,
                              @RequestBody String message){

        //System.out.println(order.toString());

        return "you sent " + message2 + "\nmessageSent : " + message;
    }

    @PostMapping("/post-order")
    public String postMap(@RequestBody Order order){
        /** todo : in the json object class that sent to the DTO (order) class you should have accessor method (getter and setter) if not you get null
         * and can not receive the object perfectly */
        System.out.println("\npostMap called " + "order : " + order.toString() + "\n");
        //System.out.println(order.toString());

        return "order : " + order.toString();
    }
    @PostMapping("/post-Transaction")
    public String postTransaction(@Valid @RequestBody Transaction transaction){
    /** todo : in the json object class that sent to the DTO (Transaction) class you should have accessor method (getter and setter) if not you get null
     * and can not receive the object perfectly */
        System.out.println("\npostTransaction called " + "Transaction : " + transaction.toString() + "\n");
        //System.out.println(order.toString());

        return "order : " + transaction.toString();
    }

    //localhost:8080/hello?showMeAllRecordOfStudent-name=paramvalue&showMeAllRecordOfStudent-lastname=value_2
    @PostMapping("/hello")
    public String postTransactionPram(
            @RequestParam("lastName") String userLastName,
            @RequestParam("username") String userName
            ){
        return "username = " + userName + "\nlastName = " + userLastName;
    }

    @GetMapping("/d/d")
    @ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
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
        /** todo : in the json object class that sent to the DTO (Student) class you should have accessor method (getter and setter) if not you get null
         * and can not receive the object perfectly */
        Student students = Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .build();

        studentRepository.save(students);
    }
}
