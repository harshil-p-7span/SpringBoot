package com.example.service;

import com.example.service.interfaces.Interface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "service")
public class Service implements Interface {
    @Override
    public void message() {
        System.out.println("Printing message from Service class");
    }
}
