package com.mastering.spring.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.mastering.spring.consumer")
@EnableHystrix
@EnableDiscoveryClient
public class ServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApplication.class, args);
	}

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}
