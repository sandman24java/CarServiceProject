package org.example.carservice.dto.auth.dto;

public record RegisterRequestDto(
        String username,
        String fullName,
        String email,
        String password
) {}
