package com.example.sanket.ll.room_web_app.data.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// JPA API based annotations like @Entity, @Table, @Id, @Column, @GeneratedValue are used to map this class to a database table.
@Entity
@Table(name="ROOMS")
@Data
public class RoomEntity {
    @Id
    @Column(name="ROOM_ID")  
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID roomId;

    @Column(name="NAME")
    private String name;

    @Column(name="NUMBER")
    private String number;

    @Column(name="BED_INFO")
    private String bedInfo;

}
