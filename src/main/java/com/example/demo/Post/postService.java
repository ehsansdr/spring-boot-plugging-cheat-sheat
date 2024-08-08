package com.example.demo.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class postService {

    private final RestClient restClient;



    // typed base on the video
    public postService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com") // the service that we are going to call
                .build();

//        RestClient restClient = RestClient.builder()
//                .requestFactory(new HttpComponentsClientHttpRequestFactory())
//                .messageConverters(converters -> converters.add(new MyCustomMessageConverter()))
//                .baseUrl("https://example.com")
//                .defaultUriVariables(Map.of("variable", "foo"))
//                .defaultHeader("My-Header", "Foo")
//                .requestInterceptor(myCustomInterceptor)
//                .requestInitializer(myCustomInitializer)
//                .build();
    }


    public List<Post> findAll() {
        return restClient.get() // it is one of http verb not getter abd setter. post() , patch(0
                .uri("/posts")  // this will add this "/" to the baseURI that we get in constructor
                .retrieve() // define how to extract response
                .body(new ParameterizedTypeReference<List<Post>>() {}); // or toEntity()

    }

    public Post findById(Integer id) {
        return restClient.get()
                .uri("/posts/{id}",id) // this will add this "/" to the baseURI that we get in constructor
                // if we do not add the correct and not existed uri we get exception
                .retrieve() // define how to extract response
                .body(Post.class); // or toEntity()
    }

    public List<Comments> findAllComment() {
        return restClient.get()
                .uri("/comments") // this will add this "/" to the baseURI that we get in constructor
                .retrieve() // define how to extract response
                .body(new ParameterizedTypeReference<List<Comments>>() {}); // or toEntity()
    }

    public Comments findCommentById(Integer id) {
        return restClient.get()
                .uri("/comments/{id}",id) // this will add this "/" to the baseURI that we get in constructor
                .retrieve() // define how to extract response
                .body(Comments.class); // or toEntity()
    }

}
