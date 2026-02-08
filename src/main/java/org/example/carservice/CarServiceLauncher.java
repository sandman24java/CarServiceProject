package org.example.carservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CarServiceLauncher {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CarServiceLauncher.class, args);
    }
}
