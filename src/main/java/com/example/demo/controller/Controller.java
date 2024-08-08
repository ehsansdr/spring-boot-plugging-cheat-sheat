package com.example.demo.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @PostMapping("/d/d/{message2}")
//    public String postMapping(@PathVariable String message2,
//                              @RequestBody String message){
//
//        //System.out.println(order.toString());
//
//        return "you sent " + message2 + "\nmessageSent : " + message;
//    }
//
//    @PostMapping("/post-order")
//    public String postMap(@RequestBody Order order){
//        /** todo : in the json object class that sent to the DTO (order) class you should have accessor method (getter and setter) if not you get null
//         * and can not receive the object perfectly */
//        System.out.println("\npostMap called " + "order : " + order.toString() + "\n");
//        //System.out.println(order.toString());
//
//        return "order : " + order.toString();
//    }
//    @PostMapping("/post-Transaction")
//    public String postTransaction(@Valid @RequestBody Transaction transaction){
//    /** todo : in the json object class that sent to the DTO (Transaction) class you should have accessor method (getter and setter) if not you get null
//     * and can not receive the object perfectly */
//        System.out.println("\npostTransaction called " + "Transaction : " + transaction.toString() + "\n");
//        //System.out.println(order.toString());
//
//        return "order : " + transaction.toString();
//    }
//
//    //localhost:8080/hello?showMeAllRecordOfStudent-name=paramvalue&showMeAllRecordOfStudent-lastname=value_2
//    @PostMapping("/hello")
//    public String postTransactionPram(
//            @RequestParam("lastName") String userLastName,
//            @RequestParam("username") String userName
//            ){
//        return "username = " + userName + "\nlastName = " + userLastName;
//    }
//
//    @GetMapping("/d/d")
//    @ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
//    public String getMapping(){
//        return "getMapping is called";
//    }
//
//
//    // for exception handler
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> handleMethodArgumentNotValidException(
//            MethodArgumentNotValidException exp
//    ) {
//        /** if you want to manage exception and get message when the bad request happen
//         *  this method will send the exact solution in explicit way
//         */
//        var errors = new HashMap<String,String>(); // first String will hold the field name
//                                                   // second String will hold the message name
//        exp.getBindingResult().getAllErrors()
//                .forEach(error -> {
//                    var fieldName = ((FieldError) error).getField();
//                    var errorMessage = error.getDefaultMessage();
//                    errors.put(fieldName, errorMessage);
//                });
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
//
//    @PostMapping("/addData")
//    public void addData(@Valid @RequestBody Student student){   // @Valid is necessary
//        /** todo : in the json object class that sent to the DTO (Student) class you should have accessor method (getter and setter) if not you get null
//         * and can not receive the object perfectly */
//        Student students = Student.builder()
//                .firstName(student.getFirstName())
//                .lastName(student.getLastName())
//                .build();
//
//        studentRepository.save(students);
//    }
//
//
//    @GetMapping("/getS/{id}")
//    public List<Student> getS(@PathVariable Long id){
//
//        return studentRepository.findAll();
//    }

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/age")
    ResponseEntity<String> age(
            @RequestParam("yearOfBirth") int yearOfBirth) {

        if (yearOfBirth > 1995) {
            return new ResponseEntity<>(
                    "Year of birth cannot be in the future",
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                "Your yearOfBirth is " + yearOfBirth,
                HttpStatus.OK);
    }

    @GetMapping("/customHeader1")
    ResponseEntity<String> customHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");

        return new ResponseEntity<>(
                "Custom header set", headers, HttpStatus.OK);
    }
    @GetMapping("/helloResponseEntity")
    ResponseEntity<String> helloResponseEntity() {
        return ResponseEntity.ok("Hello World!");
    }
    @GetMapping("/customHeader2")
    ResponseEntity<String> customHeader2() {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body("Custom header set"); // it should be the last call.

        // Since BodyBuilder.body() returns a ResponseEntity instead of BodyBuilder, it should be the last call.
        // Note that with HeaderBuilder we can’t set any properties of the response body.
    }

    @GetMapping("/customHeader3")
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid")
    ResponseEntity<String> customHeader3() {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body("Custom header set"); // it should be the last call.

        // Since BodyBuilder.body() returns a ResponseEntity instead of BodyBuilder, it should be the last call.
        // Note that with HeaderBuilder we can’t set any properties of the response body.
    }

    @GetMapping("/greeting2")
    public ResponseEntity<String> greeting2(@RequestHeader(name = "Custom") String language) {
        /*
         just one parameter can have @RequestHeader
         the second one and the third one will not be considered
         the header value of the header name that match to the header name will save in the
         annotated parameter
         If we use a Map and one of the headers has more than one value, we’ll get only the first value.
         This is the equivalent of using the getFirst method on a MultiValueMap.
         code that uses the language variable
        */

        return new ResponseEntity<String>(language, HttpStatus.OK);
    }
    @GetMapping("/double")
    public ResponseEntity<String> doubleNumber(@RequestHeader("my-number") int  myNumber) {
        System.out.println("doubleNumber");
        return new ResponseEntity<String>(String.format("%d * 2 = %d",
                myNumber, (myNumber * 2)), HttpStatus.OK);
    }

    @GetMapping("/HostChecking")
    public String hostChecking(@RequestHeader("f") String headers) {

        return String.format("Header '%s' ", headers);
    }


}
