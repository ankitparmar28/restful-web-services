package com.poc.rest.webservices.restfulwebservices.dao;

import com.poc.rest.webservices.restfulwebservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
