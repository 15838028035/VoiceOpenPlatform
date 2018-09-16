package com.thinkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TtsConsumer_App {
    public static void main(String[] args) {
        SpringApplication.run(TtsConsumer_App.class,args);
    }
}
