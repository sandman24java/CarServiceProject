package org.example.module3.layered.dto;

public record ModelDto(
        Integer id,
        String name,
        String category,
        Integer yearFrom,
        Integer yearTo
)
{
    public ModelDto(String name, String category, Integer yearFrom, Integer yearTo){
        this(null,name,category,yearFrom,yearTo);
    }
}
