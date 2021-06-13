package com.poc.rest.webservices.restfulwebservices.dao;

import com.poc.rest.webservices.restfulwebservices.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByUserId(Integer userId);
}
