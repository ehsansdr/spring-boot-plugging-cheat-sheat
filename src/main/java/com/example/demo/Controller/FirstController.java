package com.example.demo.Controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class FirstController {


    private static final Logger LOGGER = Logger.getLogger(FirstController.class.getName());


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



}
