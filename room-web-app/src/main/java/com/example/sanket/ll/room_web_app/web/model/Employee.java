package com.example.sanket.ll.room_web_app.web.model;

import java.util.UUID;

import com.example.sanket.ll.room_web_app.data.entity.Position;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private UUID id;
    private String firstname;
    private String lastname;
    private Position position;
}
