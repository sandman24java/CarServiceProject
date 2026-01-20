package org.example.module3.layered.dto;

public record BrandDto(Integer id, String name, String country, Integer foundedYear) {
    public BrandDto(String name,String country, Integer foundedYear){
        this(null,name,country,foundedYear);
    }
}
