package com.poc.rest.webservices.restfulwebservices.service;

import com.poc.rest.webservices.restfulwebservices.dao.PostRepository;
import com.poc.rest.webservices.restfulwebservices.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post savePost(Post post){
        return postRepository.save(post);
    }
}
