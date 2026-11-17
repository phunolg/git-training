package com.example.employeemanagement.controller;

import java.net.URI;
import java.util.List;

import com.example.employeemanagement.dto.CreateEmployeeRequest;
import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(
            @RequestParam(required = false) String department) {
        return ResponseEntity.ok(employeeService.findAll(department));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        Employee employee = employeeService.findById(id);
        return employee == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody CreateEmployeeRequest request) {
        Employee employee = employeeService.create(request);
        return ResponseEntity
                .created(URI.create("/api/employees/" + employee.getId()))
                .body(employee);
    }
}
