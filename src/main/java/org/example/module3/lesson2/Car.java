package org.example.module3.lesson2;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class Car {
    private String color;
    private int year;
    private String model;
}
