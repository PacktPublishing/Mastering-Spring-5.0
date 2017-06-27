package com.mastering.spring.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DevSpecificConfiguration {

    @Profile("dev")
    @Bean
    public String cache() {
        return "Dev Cache Configuration";
    }
}