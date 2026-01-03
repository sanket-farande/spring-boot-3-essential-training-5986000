package com.frankmoley.lil.roomclr;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RoomClrApplication {

  public static void main(String[] args) {
    SpringApplication.run(RoomClrApplication.class, args);
  }

  // Instantiate a RestTemplate bean, which we will use to call other services
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public CommandLineRunner run(RestTemplate restTemplate) {
    return args -> {
      // Calling another room service with RestTemplate
      ResponseEntity<List<Room>> rooms = restTemplate.exchange("http://localhost:8080/api/rooms", HttpMethod.GET, null,
          new ParameterizedTypeReference<List<Room>>() {
          });
      rooms.getBody().forEach(System.out::println);
      // for (int i = 1; i <= 100; i++) {
      // System.out.println("Counting: " + i);
      // }
    };
  }

}
