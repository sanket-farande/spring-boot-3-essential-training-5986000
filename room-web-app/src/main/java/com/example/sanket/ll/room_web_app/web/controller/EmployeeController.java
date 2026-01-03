package com.example.sanket.ll.room_web_app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sanket.ll.room_web_app.services.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployeesPage(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }
}
