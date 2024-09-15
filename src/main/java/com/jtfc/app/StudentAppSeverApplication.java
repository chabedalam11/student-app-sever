package com.jtfc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentAppSeverApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAppSeverApplication.class, args);
		System.out.println("Student Server Up & Running");
	}

}
