package org.example.module3.layered.dto;

public record CarDto(String name,int speed, String color, Integer id) {
    public CarDto(String name, int speed, String color){
        this(name, speed, color, 0);
    }
}
