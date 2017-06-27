package com.mastering.spring.cloud.data.flow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class EventStoreSinkApplication {

	private static Logger logger = LoggerFactory.getLogger(EventStoreSinkApplication.class);

	@StreamListener(Sink.INPUT)
	public void loggerSink(StockPriceChangeEventWithHoldings event) {
		logger.info("Received: " + event);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(EventStoreSinkApplication.class, args);
	}
}
