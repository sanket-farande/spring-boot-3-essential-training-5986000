package com.frankmoley.lil.booting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Configures this class as a Spring Boot application
// Is equivalent to using @Configuration, @EnableAutoConfiguration, and @ComponentScan with their default attributes
@SpringBootApplication
public class BootingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootingApplication.class, args);
	}

}
