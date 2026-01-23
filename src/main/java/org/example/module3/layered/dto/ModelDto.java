package org.example.module3.layered.dto;

public record ModelDto(
        Long id,
        String name,
        String category,
        Integer yearFrom,
        Integer yearTo
) {}
