package com.samuel.microservice.ueb3library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ueb3libraryApplication {

	public static void main(String[] args) {
		System.out.println("Das ist die neue Version mit Docker");
		SpringApplication.run(Ueb3libraryApplication.class, args);
	}

}
