package com.example.sanket.ll.room_web_app.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Model as per thymeleaf variables set in view template
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private UUID id;
    private String name;
    private String number;
    private String info;
}
