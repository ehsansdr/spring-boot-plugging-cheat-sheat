package com.example.demo.Controller;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
