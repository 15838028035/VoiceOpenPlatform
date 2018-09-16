package com.thinkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VoicePrint_privoder_App {
    public static void main(String[] args) {
        SpringApplication.run(VoicePrint_privoder_App.class,args);
    }
}
