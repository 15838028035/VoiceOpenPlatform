package com.thinkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Console_Privoder_App {
    public static void main(String[] args) {
        SpringApplication.run(Console_Privoder_App.class,args);
    }
}
