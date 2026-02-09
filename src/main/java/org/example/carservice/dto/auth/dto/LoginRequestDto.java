package org.example.carservice.dto.auth.dto;

import org.example.carservice.annotations.LogIgnore;

public record LoginRequestDto(
        String username,
        @LogIgnore String password
) {}
