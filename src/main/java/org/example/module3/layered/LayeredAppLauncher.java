package org.example.module3.layered;

import org.example.module3.layered.service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LayeredAppLauncher {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(LayeredAppLauncher.class, args);

        CarService myService = ctx.getBean(CarService.class);
        System.out.println("Loaded implementation: " + myService.getClass().getName());
    }
}
