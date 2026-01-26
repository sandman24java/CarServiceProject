package org.example.module3.layered.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.example.module3.layered.model.ModelEntity;

import java.util.List;

public record BrandDto(Long id,
                       @NotBlank(message = "name can not be empty or null") String name,
                       String country,
                       @Positive(message="founded year must be positive") @Min(1900) @Max(2100)Integer foundedYear,
                       List<ModelDto> modelDtoList) {
    public BrandDto(@NotBlank String name,String country, Integer foundedYear){
        this(null,name,country,foundedYear,null);
    }
}
