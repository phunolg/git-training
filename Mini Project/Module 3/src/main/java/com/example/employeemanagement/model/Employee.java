package com.example.employeemanagement.model;

public class Employee {

    private final long id;
    private final String name;
    private final String department;
    private final String position;

    public Employee(long id, String name, String department, String position) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }
}
