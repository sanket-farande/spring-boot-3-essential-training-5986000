package com.example.sanket.ll.room_web_app.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sanket.ll.room_web_app.data.entity.RoomEntity;

// JPA Repository interface for RoomEntity, providing CRUD operations and more.
public interface RoomRepository extends JpaRepository<RoomEntity, UUID>{

}
