package com.mastering.spring.reactive;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mastering.spring.reactive.model.Stock;
import com.mastering.spring.reactive.repository.StockMongoReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StockPriceEventController {

	Logger logger = Logger.getLogger(StockPriceEventController.class);

	private final StockMongoReactiveCrudRepository repository;

	public StockPriceEventController(StockMongoReactiveCrudRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/stocks")
	Flux<Stock> list() {
		return this.repository.findAll().log();
	}

	@GetMapping("/stocks/{code}")
	Mono<Stock> findById(@PathVariable("code") String code) {
		return this.repository.findById(code).log();
	}

	@GetMapping("/stocks/price/{stockCode}")
	Flux<String> retrieveStockPriceHardcoded(@PathVariable("stockCode") String stockCode) {
		return Flux.interval(Duration.ofSeconds(5)).map(l -> getCurrentDate() + " : " + getRandomNumber(100, 125))
				.log();
	}

	private String getCurrentDate() {
		return (new Date()).toString();
	}

	private int getRandomNumber(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

}