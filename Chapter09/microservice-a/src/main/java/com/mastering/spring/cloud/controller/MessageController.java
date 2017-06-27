package com.mastering.spring.cloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastering.spring.cloud.configuration.ApplicationConfiguration;

@RestController
public class MessageController {

	@Autowired
	private ApplicationConfiguration configuration;

	@RequestMapping("/message")
	public Map<String, String> welcome() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", configuration.getMessage());
		return map;
	}
}