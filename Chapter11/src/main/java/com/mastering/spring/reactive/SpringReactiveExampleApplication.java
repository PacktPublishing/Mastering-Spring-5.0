package com.mastering.spring.reactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mastering.spring.reactive.model.Stock;
import com.mastering.spring.reactive.repository.StockMongoReactiveCrudRepository;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringReactiveExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(StockMongoReactiveCrudRepository mongoRepository) {
		return (p) -> {
			mongoRepository.deleteAll().block();
			mongoRepository.save(new Stock("IBM", "IBM Corporation", "Desc")).block();
			mongoRepository.save(new Stock("GGL", "Google", "Desc")).block();
			mongoRepository.save(new Stock("MST", "Microsoft", "Desc")).block();
		};
	}

}
