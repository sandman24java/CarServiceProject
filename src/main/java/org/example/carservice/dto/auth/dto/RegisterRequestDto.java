package org.example.carservice.dto.auth.dto;

import org.example.carservice.annotations.LogIgnore;

public record RegisterRequestDto(
        String username,
        String fullName,
        String email,
        @LogIgnore String password
) {}
