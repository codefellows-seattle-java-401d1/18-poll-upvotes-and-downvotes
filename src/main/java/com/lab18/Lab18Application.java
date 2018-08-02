package com.lab18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab18Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab18Application.class, args);
		System.out.println("http://localhost:8080");
	}
}
