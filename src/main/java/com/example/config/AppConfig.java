package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

@Configuration
public class AppConfig {

    @Bean(name = "bean")
    @Order(1)
    /*used to specify the order or priority of beans when
    multiple instances of the same type are present.*/
    public String message(){
        System.out.println("bean created");
        return "Hello Java!";
    }

    @Bean(name = "firstBean")
    @Order(3)
    @Lazy
    /*used to indicate that a bean should be lazily initialized,
    deferring its creation until it is explicitly requested or injected
    into another bean.*/
    public String firstBean(){
        System.out.println("first bean created");
        return "First Bean";
    }

    @Bean(name = "secondBean")
    @Order(2)
    public String secondBean(){
        System.out.println("second bean created");
        return "Second Bean";
    }
}
