package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProjectApplication {



	public static void main(String[] args) {
		System.out.println("Application running");
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

}
