package org.example.carservice.advisors;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.carservice.annotations.LogIgnore;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
@Slf4j
public class LoggingMechanism {



    @Around("execution(* org.example.carservice.controller.auth.controller.AuthController.*(..)) || " +
            "execution(* org.example.carservice.controller.cars.controller.BrandController.*(..)) || " +
    "execution(* org.example.carservice.controller.cars.controller.CarController.*(..)) || " +
    "execution(* org.example.carservice.controller.cars.controller.ModelController.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        if(args!=null){
            for (Object arg:args){
                logWithFiltering(arg,"Part of Request Logging");
                    }
            }

        Object result = joinPoint.proceed();
        if (result != null) {
            logWithFiltering(result,"Part of Response Logging");
        }
        return result;
    };

    private void logWithFiltering(Object obj, String description){

        if (obj instanceof String || obj instanceof Number) {
            log.info("{}: {}", description, obj);
            return;
        }

        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder(obj.getClass().getSimpleName() + "{");

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.isAnnotationPresent(LogIgnore.class)
                        ? "******"
                        : field.get(obj);
                sb.append(field.getName()).append("=").append(value).append(", ");
            } catch (Exception e) {
                sb.append(field.getName()).append("=ERROR, ");
            }
        }
        log.info("{}: {})", description, sb.toString());
    }};