package org.example.module3.lesson2layered;

import org.example.module3.lesson2.AnnotationsBasedBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LayeredAppLauncher {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(LayeredAppLauncher.class, args);
    }
}
