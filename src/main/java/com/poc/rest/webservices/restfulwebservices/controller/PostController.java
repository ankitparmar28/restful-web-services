package com.poc.rest.webservices.restfulwebservices.controller;

import com.poc.rest.webservices.restfulwebservices.exception.PostNotFoundException;
import com.poc.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.poc.rest.webservices.restfulwebservices.model.Post;
import com.poc.rest.webservices.restfulwebservices.model.User;
import com.poc.rest.webservices.restfulwebservices.service.PostService;
import com.poc.rest.webservices.restfulwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    UserService userService;

    @GetMapping("/{id}/posts")
    public List<Post> getAllPostsByUser(@PathVariable("id") int id){
        User user = userService.findUser(id);
        if(null == user)
            throw new UserNotFoundException("User not found with id : "+id);
        List<Post> posts = user.getPost();
        if(posts == null || posts.isEmpty())
            throw new PostNotFoundException("Post not found for User with id : "+id);
        return posts;
    }

    @GetMapping("/{id}/posts/{postId}")
    public Post getPostDetails(@PathVariable("id") int id, @PathVariable("postId")int postId){
        User user = userService.findUser(id);
        if(null == user)
            throw new UserNotFoundException("User not found with id : "+id);
        List<Post> postList = user.getPost().stream().filter(x->x.getPostId()==postId).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(postList))
            throw new PostNotFoundException("Post not found for User with id : "+id);
        return postList.get(0);
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable("id") int id, @RequestBody Post post){
        User user = userService.findUser(id);
        if(null == user)
            throw new UserNotFoundException("User not found with id : "+id);
        post.setUser(user);
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }
}
