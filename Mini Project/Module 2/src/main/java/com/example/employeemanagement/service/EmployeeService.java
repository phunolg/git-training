package com.example.employeemanagement.service;

import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final UtilityService utilityService;
    private final PasswordEncoder passwordEncoder;

    public EmployeeService(UtilityService utilityService, PasswordEncoder passwordEncoder) {
        this.utilityService = utilityService;
        this.passwordEncoder = passwordEncoder;
    }

    public Map<String, String> createPreview(String name, String rawPassword) {
        if (rawPassword == null || rawPassword.isBlank()) {
            throw new IllegalArgumentException("Password must not be blank.");
        }

        return Map.of(
                "employeeCode", utilityService.generateEmployeeCode(),
                "displayName", utilityService.formatDisplayName(name),
                "encodedPassword", passwordEncoder.encode(rawPassword));
    }
}
