package com.example.employeemanagement.repository;

import java.util.List;

import com.example.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContainingIgnoreCaseOrDepartmentNameContainingIgnoreCase(
            String name,
            String departmentName);
}
