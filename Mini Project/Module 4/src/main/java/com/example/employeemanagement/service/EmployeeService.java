package com.example.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.entity.Department;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.DepartmentRepository;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public List<Employee> findAll(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return employeeRepository.findAll();
        }

        String normalizedKeyword = keyword.trim();
        return employeeRepository
                .findByNameContainingIgnoreCaseOrDepartmentNameContainingIgnoreCase(
                        normalizedKeyword,
                        normalizedKeyword);
    }

    @Transactional(readOnly = true)
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Transactional
    public Employee create(EmployeeRequest request) {
        Department department = getDepartment(request);
        validate(request);
        return employeeRepository.save(
                new Employee(request.name().trim(), request.email().trim(), department));
    }

    @Transactional
    public Optional<Employee> update(Long id, EmployeeRequest request) {
        return employeeRepository.findById(id).map(employee -> {
            Department department = getDepartment(request);
            validate(request);
            employee.update(request.name().trim(), request.email().trim(), department);
            return employeeRepository.save(employee);
        });
    }

    public boolean delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            return false;
        }

        employeeRepository.deleteById(id);
        return true;
    }

    private Department getDepartment(EmployeeRequest request) {
        if (request == null || request.departmentId() == null) {
            throw new IllegalArgumentException("Department ID must not be null.");
        }

        return departmentRepository.findById(request.departmentId())
                .orElseThrow(() -> new IllegalArgumentException("Department not found."));
    }

    private void validate(EmployeeRequest request) {
        if (request == null
                || request.name() == null
                || request.name().isBlank()
                || request.email() == null
                || request.email().isBlank()) {
            throw new IllegalArgumentException("Name and email must not be blank.");
        }
    }
}
