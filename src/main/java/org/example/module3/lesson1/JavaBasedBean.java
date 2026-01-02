package org.example.module3.lesson1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//В конфигурационных классах ты прямо говоришь Spring:
//«вот ТАК создавай бины»
public class JavaBasedBean {
    @Bean(name="Ford")
    public Car createCar() {
        return Car.builder()
                .color("red")
                .model("Ford Mustang")
                .year(2018)
                .build();
    }
    @Bean(name="BMW")
    public Car createCar2() {
        return Car.builder()
                .color("Black")
                .model("BMW X5")
                .year(2018)
                .build();
    }
}
