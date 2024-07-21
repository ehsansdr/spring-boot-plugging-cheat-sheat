package com.example.demo.Post;

public record Comments (
        Integer postId,
        Integer id,
        String name,
        String body,
        String email
){
}
