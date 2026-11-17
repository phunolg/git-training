package com.example.employeemanagement.service;

import java.text.Normalizer;
import java.util.Locale;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UtilityService {

    public String formatDisplayName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Employee name must not be blank.");
        }

        String normalizedName = Normalizer.normalize(name.trim(), Normalizer.Form.NFC)
                .replaceAll("\\s+", " ")
                .toLowerCase(Locale.ROOT);

        return java.util.Arrays.stream(normalizedName.split(" "))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .reduce((first, second) -> first + " " + second)
                .orElseThrow();
    }

    public String generateEmployeeCode() {
        return "EMP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase(Locale.ROOT);
    }
}
