package com.example.sanket.ll.room_web_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.sanket.ll.room_web_app.data.repository.EmployeeRepository;
import com.example.sanket.ll.room_web_app.data.repository.RoomRepository;

@SpringBootApplication
public class RoomWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomWebAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(RoomRepository roomRepository, EmployeeRepository employeeRepository){
		return args -> {
			System.out.println("Rooms:");
			roomRepository.findAll().forEach(System.out::println);
			System.out.println("Employees:");
			employeeRepository.findAll().forEach(System.out::println);
		};
	}
}
