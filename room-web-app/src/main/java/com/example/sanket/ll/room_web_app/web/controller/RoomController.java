package com.example.sanket.ll.room_web_app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sanket.ll.room_web_app.services.RoomService;

// Controller methods return view names
// REST controllers return JSON data
@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    // Avoid @autowire annotation for constructor based dependency injection
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    // Pass data to the view using Model
    public String getRoomsPage(Model model){
        // attribute rooms from thymleaf is assigned an array of model
        model.addAttribute("rooms", this.roomService.getAllRooms());
        // Should match view name
        return "rooms";
    }
}
