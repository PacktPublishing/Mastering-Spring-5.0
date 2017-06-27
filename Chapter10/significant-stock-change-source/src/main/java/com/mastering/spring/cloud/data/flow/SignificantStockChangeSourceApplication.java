package com.mastering.spring.cloud.data.flow;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(Source.class)
@SpringBootApplication
public class SignificantStockChangeSourceApplication {

	private static Logger logger = LoggerFactory.getLogger(SignificantStockChangeSourceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SignificantStockChangeSourceApplication.class, args);
	}

	@Bean
	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "60000", maxMessagesPerPoll = "1"))
	public MessageSource<StockPriceChangeEvent> stockPriceChangeEvent() {

		StockTicker[] tickers = StockTicker.values();
		String randomStockTicker = tickers[ThreadLocalRandom.current().nextInt(tickers.length)].name();

		return () -> {
			StockPriceChangeEvent event = new StockPriceChangeEvent(randomStockTicker,
					new BigDecimal(getRandomNumber(10, 20)), new BigDecimal(getRandomNumber(10, 20)));

			logger.info("sending " + event);
			return MessageBuilder.withPayload(event).build();
		};
	}

	private int getRandomNumber(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

}
