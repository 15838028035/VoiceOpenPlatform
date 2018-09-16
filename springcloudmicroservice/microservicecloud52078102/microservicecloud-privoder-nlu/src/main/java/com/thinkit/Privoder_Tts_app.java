package com.thinkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Privoder_Tts_app {

    public static void main(String[] args) {
        SpringApplication.run(Privoder_Tts_app.class,args);
    }
}
