package com.example.demo.Post;

public record Post(
        Integer id,
        Integer userId,
        String title,
        String body
) {

}
