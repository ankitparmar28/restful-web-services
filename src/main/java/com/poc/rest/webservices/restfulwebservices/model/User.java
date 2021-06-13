package com.poc.rest.webservices.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;

    @Size(min=2 , message = "Name should be at least 2 characters")
    private String name;

    @Past(message = "Birth date can not be in the past")
    private Date birthDate;

    @OneToMany(mappedBy = "user" )
    private List<Post> post;

    public User() {
    }

    public User(Integer id, String name, Date birthDate, List<Post> post) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.post = post;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", post=" + post +
                '}';
    }
}
