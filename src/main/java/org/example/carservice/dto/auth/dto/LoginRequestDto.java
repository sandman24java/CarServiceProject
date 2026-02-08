package org.example.carservice.dto.auth.dto;

public record LoginRequestDto(
        String username,
        String password
) {}
