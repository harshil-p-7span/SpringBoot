package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Component// Used to annotate classes that provide a specific service or business logic within the application.
public class UserService {

    // Used to inject values from external sources into Spring-managed beans.(Ex. application.properties)
    @Value("${application.name}")
    public String applicationName;
    private final UserRepository userRepository;

//    This is constructor dependency injection
//    In which the dependencies are provided as arguments to the constructor

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostConstruct
    // Used to annotate a method that needs to be executed after a bean has been initialized.
    public void init() {
        System.out.println("Project description : " + applicationName);
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "QAZ", 18));
        users.add(new User(2L, "WSX", 20));
        users.add(new User(3L, "EDC", 24));
        users.add(new User(4L, "RFV", 26));
        users.add(new User(5L, "TGB", 28));

        userRepository.saveAll(users);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Async
    public void printMessage() {
        try {
            Thread.sleep(5000); // Pause for 5 seconds
            System.out.println("Printing message after 5 second");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
