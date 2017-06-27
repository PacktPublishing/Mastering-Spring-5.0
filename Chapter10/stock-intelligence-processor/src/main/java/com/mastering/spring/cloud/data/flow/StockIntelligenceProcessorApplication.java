package com.mastering.spring.cloud.data.flow;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@EnableBinding(Processor.class)
@SpringBootApplication
public class StockIntelligenceProcessorApplication {

	private static Logger logger = LoggerFactory.getLogger(StockIntelligenceProcessorApplication.class);

	private static Map<StockTicker, Integer> holdings = getHoldingsFromDatabase();

	private static Map<StockTicker, Integer> getHoldingsFromDatabase() {
		final Map<StockTicker, Integer> holdings = new HashMap<>();

		holdings.put(StockTicker.FACEBOOK, 10);
		holdings.put(StockTicker.GOOGLE, 0);
		holdings.put(StockTicker.IBM, 15);
		holdings.put(StockTicker.MICROSOFT, 30);
		holdings.put(StockTicker.TWITTER, 50);

		return holdings;
	}

	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public Object addOurInventory(StockPriceChangeEvent event) {

		logger.info("started processing event " + event);
		
		logger.info("received stock ticker " + event.getStockTicker());
		
		logger.info("received stock ticker and mapped to " + StockTicker.valueOf(event.getStockTicker()));

		Integer holding = holdings.get(StockTicker.valueOf(event.getStockTicker()));
		
		logger.info("holding value is  " + holding);
		
		StockPriceChangeEventWithHoldings eventWithHoldings = new StockPriceChangeEventWithHoldings(event, holding);

		logger.info("ended processing eventWithHoldings " + eventWithHoldings);
		return eventWithHoldings;
	}

	public static void main(String[] args) {
		SpringApplication.run(StockIntelligenceProcessorApplication.class, args);
	}
}
