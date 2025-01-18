package com.example.demo.Controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("quantity")
    private int quantity;


    // create getter and setter if not and send the data the data will not get in the feild


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
