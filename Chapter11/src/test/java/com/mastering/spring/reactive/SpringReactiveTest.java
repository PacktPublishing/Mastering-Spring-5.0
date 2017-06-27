package com.mastering.spring.reactive;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SpringReactiveTest {

	
	class SystemOutConsumer implements Consumer<String> {

		@Override
		public void accept(String t) {
			System.out.println("Received " + t + " at " + new Date());

		}

	}

	class WelcomeConsumer implements Consumer<String> {

		@Override
		public void accept(String t) {
			System.out.println("Welcome " + t);

		}

	}

	@Test
	public void monoExample() throws InterruptedException {
		Mono<String> stubMonoWithADelay = Mono.just("Ranga").delayElement(Duration.ofSeconds(5));

		stubMonoWithADelay.subscribe(new SystemOutConsumer());
		//stubMonoWithADelay.subscribe(new WelcomeConsumer());

		Thread.sleep(10000);
	}

	private static List<String> streamOfNames = Arrays.asList("Ranga", "Adam", "Joe", "Doe", "Jane");

	@Test
	public void simpleFluxStream() {
		Flux<String> stubFluxStream = Flux.just("Jane", "Joe");
		stubFluxStream.subscribe(new SystemOutConsumer());
	}


	@Test
	public void fluxStreamWithDelay() throws InterruptedException {
		Flux<String> stubFluxWithNames = Flux.fromIterable(streamOfNames).delayElements(Duration.ofMillis(1000));
		stubFluxWithNames.subscribe(new SystemOutConsumer());
		stubFluxWithNames.subscribe(new WelcomeConsumer());
		Thread.sleep(10000);
	}


}
