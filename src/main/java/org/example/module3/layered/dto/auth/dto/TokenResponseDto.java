package org.example.module3.layered.dto.auth.dto;

public record TokenResponseDto(
        String accessToken,
        String refreshToken
) {}
