package com.example.demo.cotrolSetting;

import org.springframework.web.bind.annotation.*;

//@RestController
public class Controller {


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
    public String postTransaction(@RequestBody Transaction transaction){

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
}
