package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// Instead of rest controller annotation we can on controller annotation
// but we have to use response body annotation with that on each mapping.
public class UserController {

    private UserService userService;

    // This setter dependency injection
    // In which dependency passing in setter method and annotate with @Autowire annotation.
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
