package com.mastering.spring.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {

	private Log log = LogFactory.getLog(RandomNumberController.class);
	
	@RequestMapping("/random")
	public List<Integer> random() {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++) {
			numbers.add(generateRandomNumber());
		}
		log.warn("Returning " + numbers);
		return numbers;
	}

	private int generateRandomNumber() {
		return (int) (Math.random() * 1000);
	}
}