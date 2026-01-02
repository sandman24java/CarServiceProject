package org.example.module3.lesson1;

import lombok.*;


@Builder
@Getter
@Setter
public class Car {
    private String color;
    private int year;
    private String model;
}
