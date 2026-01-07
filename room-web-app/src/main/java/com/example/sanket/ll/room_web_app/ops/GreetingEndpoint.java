package com.example.sanket.ll.room_web_app.ops;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "greeting")
public class GreetingEndpoint {
    // actuator endpoint example with read operation only
    @ReadOperation
    public String greetings() {
        return "Hello World";
    }
}
