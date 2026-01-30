package org.example.module3.layered.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ModelDto(
        Integer id,
        String name,
        String category,
        Integer yearFrom,
        Integer yearTo,
        List<CarDto> carDtoList
)
{
    public ModelDto(
            Integer id,
            String name,
            String category,
            Integer yearFrom,
            Integer yearTo)
    {
            this(null,name,category,yearFrom,yearTo,null);
        }
    }

