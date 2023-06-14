package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootProjectApplication {

    public static void main(String[] args) {
        System.out.println("Application running");
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

}
