package com.thinkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.thinkit"})
@ComponentScan(basePackages= {"com.thinkit"})
public class Comsumer_Services_App {
    public static void main(String[] args) {
        SpringApplication.run(Comsumer_Services_App.class,args);
    }
}
