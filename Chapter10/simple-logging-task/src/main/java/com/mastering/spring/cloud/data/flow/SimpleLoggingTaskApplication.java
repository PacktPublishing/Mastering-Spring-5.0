package com.mastering.spring.cloud.data.flow;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SimpleLoggingTaskApplication {

	@Bean
	public CommandLineRunner commandLineRunner() {
		return strings -> System.out.println("Task execution :" + new SimpleDateFormat().format(new Date()));
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleLoggingTaskApplication.class, args);
	}
}
