package org.example.module3.lesson2layered.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Setter
@Getter
public class CarEntity {
    private String name;
    private int speed;
    private String color;
    private int id;

    public CarEntity(String name, int speed, String color) {
        this.name = name;
        this.color = color;
        this.speed = speed;
    }

}
