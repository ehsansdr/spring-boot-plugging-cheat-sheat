package com.example.demo.cotrolSetting;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Order {
    /** todo : in the json object class that sent to the DTO class you should have accessor method (getter and setter) if not you get null
     * and can not receive the object perfectly */

    //@JsonProperty("(name that you want to use just in postman or ...)")
    private String customerName;
    private String productName;
    private Integer numberOfProduct;




    @Override
    public String toString() {
        return "Order{" +
                "\n\tcustomerName = '" + customerName + '\'' +
                ",\n\tproductName = '" + productName + '\'' +
                ",\n\tnumberOfProduct = " + numberOfProduct +
                "\n\t}";
    }
}
