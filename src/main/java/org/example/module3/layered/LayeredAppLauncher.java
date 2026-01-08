package org.example.module3.layered;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LayeredAppLauncher {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(LayeredAppLauncher.class, args);
    }
}
