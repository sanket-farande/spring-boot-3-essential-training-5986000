package com.example.sanket.ll.room_web_app.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sanket.ll.room_web_app.data.entity.RoomEntity;
import com.example.sanket.ll.room_web_app.data.repository.RoomRepository;
import com.example.sanket.ll.room_web_app.web.model.Room;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    // Avoid @autowire annotation for constructor based dependency injection
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    // Pass data to the view using Model
    public String getRoomsPage(Model model){
        List<RoomEntity> roomEntities = this.roomRepository.findAll();
        List<Room> rooms = new ArrayList<>(roomEntities.size());
        roomEntities.forEach(e -> rooms.add(new Room(e.getRoomId(), e.getName(), e.getNumber(), e.getBedInfo())));
        // attribute rooms from thymleaf is assigned an array of model
        model.addAttribute("rooms", rooms);
        // Should match view name
        return "rooms";
    }
}
