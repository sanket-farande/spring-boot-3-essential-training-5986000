package com.example.sanket.ll.room_web_app.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sanket.ll.room_web_app.data.entity.EmployeeEntity;
import com.example.sanket.ll.room_web_app.data.repository.EmployeeRepository;
import com.example.sanket.ll.room_web_app.web.model.Employee;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String getEmployeesPage(Model model){
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>(employeeEntities.size());
        employeeEntities.forEach(e -> employees.add(new Employee(e.getEmployeeId(), e.getFirstName(), e.getLastName(), e.getPosition())));
        model.addAttribute("employees", employees);
        return "employees";
    }
}
