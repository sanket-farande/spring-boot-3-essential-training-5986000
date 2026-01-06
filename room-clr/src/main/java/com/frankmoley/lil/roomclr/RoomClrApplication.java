package com.frankmoley.lil.roomclr;

import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class RoomClrApplication {

  private static final String QUEUE_NAME = "room-cleaner";
  private static final String EXCHANGE_NAME = "operations";

  @Bean
  public Queue queue() {
    return new Queue(QUEUE_NAME, false);
  }

  @Bean
  public TopicExchange exchage() {
    return new TopicExchange(EXCHANGE_NAME);
  }

  @Bean
  public Binding binding(Queue queue, TopicExchange topicExchange) {
    return BindingBuilder.bind(queue).to(topicExchange).with("landon.#");
  }

  // Instantiate a RestTemplate bean, which we will use to call other services
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public CommandLineRunner run(RestTemplate restTemplate, RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
    return args -> {
      // Calling another room service with RestTemplate
      ResponseEntity<List<Room>> rooms = restTemplate.exchange("http://localhost:8080/api/rooms", HttpMethod.GET, null,
          new ParameterizedTypeReference<List<Room>>() {
          });
      rooms.getBody().forEach(r -> {
        AsyncPayload asyncPayload = new AsyncPayload();
        asyncPayload.setId(r.getId());
        asyncPayload.setModel("ROOMS");
        try {
          rabbitTemplate.convertAndSend(EXCHANGE_NAME, "landon.rooms.cleaner",
              objectMapper.writeValueAsString(asyncPayload));
        } catch (JsonProcessingException e) {
          throw new RuntimeException(e);
        }
      });
      // for (int i = 1; i <= 100; i++) {
      // System.out.println("Counting: " + i);
      // }
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(RoomClrApplication.class, args);
  }

}
