package com.amycohen.day18_poll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day18PollApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day18PollApplication.class, args);
		System.out.println("http://localhost:9090");
	}
}
