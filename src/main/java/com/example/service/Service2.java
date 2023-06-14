package com.example.service;

import com.example.service.interfaces.Interface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier(value = "service2")
public class Service2 implements Interface {
    @Override
    public void message() {
        System.out.println("Printing message from Service2 class.");
    }
}
