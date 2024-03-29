package com.example.demo.cotrolSetting;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    private String customerName;
    private String productName;
    private Integer numberOfProduct;


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

    public Integer getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(Integer numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    @Override
    public String toString() {
        return "Order{" +
                "\n\tcustomerName = '" + customerName + '\'' +
                ",\n\tproductName = '" + productName + '\'' +
                ",\n\tnumberOfProduct = " + numberOfProduct +
                "\n\t}";
    }
}
