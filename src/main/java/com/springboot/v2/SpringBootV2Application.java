package com.springboot.v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootV2Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringBootV2Application.class, args);
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println("app starting " + name);
        }
    }

}

