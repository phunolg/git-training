package com.example.employeemanagement.dto;

public record EmployeeRequest(
        String name,
        String email,
        Long departmentId) {
}
