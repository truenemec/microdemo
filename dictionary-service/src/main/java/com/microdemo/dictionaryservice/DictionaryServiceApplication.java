package com.microdemo.dictionaryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class DictionaryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DictionaryServiceApplication.class, args);
    }
}
