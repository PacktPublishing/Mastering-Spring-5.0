package com.mastering.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAApplication.class, args);
	}

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}
