package org.example.module3.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("FirstBean")
public class AnnotationsBasedBean {

    //FIELD Injection
    @Autowired
    @Qualifier("BMW")
    private Car carFieldInjection;

    //SETTER Injection 1.1
    private Car carSetterInjection;

    //CONSTRUCTOR Injection 1.1
    private final Car carConstructorInjection;

    //SETTER Injection 1.2
    @Autowired
    private void setCar(@Qualifier("Ford") Car carSetterInjection) {
        this.carSetterInjection = carSetterInjection;
    }

    //CONSTRUCTOR Injection 1.2
    @Autowired
    public AnnotationsBasedBean(@Qualifier("Mercedes") Car carConstructorInjection) {
        this.carConstructorInjection = carConstructorInjection;
    }

    public void printMessage(){
        System.out.println("You have injected via Field Injection the " + carFieldInjection.getModel() + " inside of AnnotationsBasedBean");
        System.out.println("You have injected via Setter Injection the " + carSetterInjection.getModel()+ " inside of AnnotationsBasedBean");
        System.out.println("You have injected via Constructor Injection the " +  carConstructorInjection.getModel()+ " inside of AnnotationsBasedBean");
    }
}
