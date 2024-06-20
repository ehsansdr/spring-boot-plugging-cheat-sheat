package com.example.demo.cotrolSetting;

public record Transaction(
        String customerName,
        String productName,
        Integer numberOfProduct
) {
    /** todo : in the json object class that sent to the DTO class you should have accessor method (getter and setter) if not you get null
     * and can not receive the object perfectly */
}
