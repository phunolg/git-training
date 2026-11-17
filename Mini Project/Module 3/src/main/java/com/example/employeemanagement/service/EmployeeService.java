package com.example.employeemanagement.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.example.employeemanagement.dto.CreateEmployeeRequest;
import com.example.employeemanagement.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final AtomicLong nextId = new AtomicLong(3);
    private final List<Employee> employees = new CopyOnWriteArrayList<>(List.of(
            new Employee(1, "Nguyen Van A", "IT", "Backend Developer"),
            new Employee(2, "Tran Thi B", "Human Resources", "HR Specialist")));

    public List<Employee> findAll(String department) {
        if (department == null || department.isBlank()) {
            return List.copyOf(employees);
        }

        return employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department.trim()))
                .toList();
    }

    public Employee findById(long id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Employee create(CreateEmployeeRequest request) {
        validate(request);

        Employee employee = new Employee(
                nextId.getAndIncrement(),
                request.name().trim(),
                request.department().trim(),
                request.position().trim());
        employees.add(employee);
        return employee;
    }

    private void validate(CreateEmployeeRequest request) {
        if (request == null
                || isBlank(request.name())
                || isBlank(request.department())
                || isBlank(request.position())) {
            throw new IllegalArgumentException("Name, department and position must not be blank.");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
