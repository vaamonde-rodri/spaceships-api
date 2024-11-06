package com.rodrigovaamonde.spaceships;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EntityScan(basePackages = "com.rodrigovaamonde.spaceships")
@EnableCaching
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}