package com.example.demo.Post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostControllers {
    // https://jsonplaceholder.typicode.com/
    // https://jsonplaceholder.typicode.com/posts


    private postService postService;

    public PostControllers(postService postService) {
        this.postService = postService;
    }

    // to find all the post in the system
    @GetMapping
    List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    Post findById(@PathVariable Integer id){
        return postService.findById(id);
    }

    @GetMapping("/comments")
    List<Comments> findAllComnets(){
        return postService.findAllComment();
    }
}
