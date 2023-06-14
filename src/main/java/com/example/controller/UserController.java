package com.example.controller;

import com.example.entity.User;
import com.example.service.interfaces.Interface;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// Instead of rest controller annotation we can on controller annotation
// but we have to use response body annotation with that on each mapping.
public class UserController {

    private UserService userService;

    private final Interface anInterface;

    // If we don't use qualifier than it take been based on @Pirmary annotation.
    public UserController(@Qualifier("service") Interface anInterface) {
        this.anInterface = anInterface;
    }

    // This setter dependency injection
    // In which dependency passing in setter method and annotate with @Autowire annotation.
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        messaeg();
        return userService.getUsers();
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/sendEmail")
    public String printMessage() {
        userService.printMessage();
        return "Message send successfully";
    }

    public void messaeg(){
        anInterface.message();
    }
}
