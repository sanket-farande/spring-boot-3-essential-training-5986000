package com.example.sanket.ll.room_web_app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sanket.ll.room_web_app.data.entity.EmployeeEntity;
import com.example.sanket.ll.room_web_app.data.repository.EmployeeRepository;
import com.example.sanket.ll.room_web_app.web.model.Employee;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>(employeeEntities.size());
        employeeEntities.forEach(e -> employees.add(getEmployeeFromEntity(e)));
        return employees;
    }

    private Employee getEmployeeFromEntity(EmployeeEntity employeeEntity) {
        return new Employee(employeeEntity.getEmployeeId(), employeeEntity.getFirstName(), employeeEntity.getLastName(),
                employeeEntity.getPosition());
    }
}
