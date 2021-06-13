package com.poc.rest.webservices.restfulwebservices.service;

import com.poc.rest.webservices.restfulwebservices.dao.UserRepository;
import com.poc.rest.webservices.restfulwebservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User findUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            return user.get();
        return null;
    }
}
