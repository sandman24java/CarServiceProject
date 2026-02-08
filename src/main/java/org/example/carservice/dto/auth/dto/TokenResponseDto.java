package org.example.carservice.dto.auth.dto;

public record TokenResponseDto(
        String accessToken,
        String refreshToken
) {}
