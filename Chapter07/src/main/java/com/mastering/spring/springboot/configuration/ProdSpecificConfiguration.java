package com.mastering.spring.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProdSpecificConfiguration {

    @Profile("prod")
    @Bean
    public String cache() {
        return "Production Cache Configuration - Distributed Cache";
    }
}