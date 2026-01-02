package org.example.module3.lesson1;

import org.springframework.stereotype.Component;

@Component("FirstBean")
public class AnnotationsBasedBean {
    public void printMessage(){
        System.out.println("Hello World");
    }
}
