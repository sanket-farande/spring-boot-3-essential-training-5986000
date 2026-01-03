package com.example.sanket.ll.room_web_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.sanket.ll.room_web_app.data.entity.RoomEntity;
import com.example.sanket.ll.room_web_app.data.repository.RoomRepository;
import com.example.sanket.ll.room_web_app.web.model.Room;

// Service layer to handle business logic and avoid repetitive code in controllers
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        List<RoomEntity> roomEntities = this.roomRepository.findAll();
        List<Room> rooms = new ArrayList<>(roomEntities.size());
        roomEntities.forEach(e -> rooms.add(getRoomFromEntity(e)));
        return rooms;
    }

    public Room getRoomById(UUID roomId) {
        Optional<RoomEntity> roomEntity = this.roomRepository.findById(roomId);
        if (roomEntity.isEmpty()) {
            return null;
        } else {
            return getRoomFromEntity(roomEntity.get());
        }
    }

    public Room addRoom(Room room) {
        RoomEntity roomEntity = getEntityFromRoom(room);
        roomEntity = this.roomRepository.save(roomEntity);
        return getRoomFromEntity(roomEntity);
    }

    public Room updateRoom(Room room) {
        RoomEntity roomEntity = getEntityFromRoom(room);
        roomEntity = this.roomRepository.save(roomEntity);
        return getRoomFromEntity(roomEntity);
    }

    public void deleteRoom(UUID id){
        this.roomRepository.deleteById(id);
    }

    private Room getRoomFromEntity(RoomEntity roomEntity) {
        return new Room(roomEntity.getRoomId(), roomEntity.getName(), roomEntity.getNumber(), roomEntity.getBedInfo());
    }

    private RoomEntity getEntityFromRoom(Room room) {
        return new RoomEntity(room.getId(), room.getName(), room.getNumber(), room.getInfo());
    }

}
