package org.example.module3.layered.dto;

import org.example.module3.layered.model.ModelEntity;

import java.util.List;

public record BrandDto(Long id, String name, String country, Integer foundedYear, List<ModelDto> modelDtoList) {
    public BrandDto(String name,String country, Integer foundedYear){
        this(null,name,country,foundedYear,null);
    }
}
