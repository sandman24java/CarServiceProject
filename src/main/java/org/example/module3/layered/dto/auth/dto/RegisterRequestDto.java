package org.example.module3.layered.dto.auth.dto;

public record RegisterRequestDto(
        String username,
        String fullName,
        String email,
        String password
) {}
