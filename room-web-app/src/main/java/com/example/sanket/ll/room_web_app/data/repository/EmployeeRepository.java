package com.example.sanket.ll.room_web_app.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sanket.ll.room_web_app.data.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID>{

}
