package com.example.demo.DTO;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
