package com.example.sanket.ll.room_web_app;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.sanket.ll.room_web_app.async.RoomCleanerListener;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AsyncConfig {

    private static final String QUEUE_NAME = "room-cleaner";
    private static final String EXCHANGE_NAME = "operations";

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    // method to create queue
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    // method to create topic exchange
    public TopicExchange exchage() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    // method to bind queue to exchange with routing key
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("landon.rooms.cleaner");
    }

    @Bean
    // method to configure message listener adapter
    public MessageListenerAdapter listenerAdapter (RoomCleanerListener listener){
        return new MessageListenerAdapter(listener, "receiveMessage");
    }

    @Bean
    // method to configure message listener container 
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }
}
