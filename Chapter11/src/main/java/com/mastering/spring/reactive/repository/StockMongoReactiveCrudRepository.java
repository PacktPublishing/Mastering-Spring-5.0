package com.mastering.spring.reactive.repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.mastering.spring.reactive.model.Stock;

public interface StockMongoReactiveCrudRepository extends ReactiveCrudRepository<Stock, String> {

}
