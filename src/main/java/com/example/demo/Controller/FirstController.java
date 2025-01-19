package com.example.demo.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

    @GetMapping("/is-success-2")
    public ResponseEntity<String> sayHello11(@RequestBody Boolean isSucess) {
        LOGGER.info("FirstController.class sayHello11() GET /is-success-2");

        if (isSucess) {
            return new ResponseEntity<>("Request is successful", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Request is not successful", HttpStatus.BAD_REQUEST);
        }
    }

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

}
