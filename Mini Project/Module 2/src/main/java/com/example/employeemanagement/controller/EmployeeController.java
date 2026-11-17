package com.example.employeemanagement.controller;

import java.util.Map;

import com.example.employeemanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Employee Management System!";
    }

    @GetMapping("/employees/preview")
    public Map<String, String> createPreview(
            @RequestParam String name,
            @RequestParam String password) {
        return employeeService.createPreview(name, password);
    }
}
