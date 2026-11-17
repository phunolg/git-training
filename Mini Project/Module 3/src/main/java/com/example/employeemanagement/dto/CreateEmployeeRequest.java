package com.example.employeemanagement.dto;

public record CreateEmployeeRequest(
        String name,
        String department,
        String position) {
}
