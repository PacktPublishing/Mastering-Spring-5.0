package com.mastering.spring.springboot.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mastering.spring.springboot.bean.WelcomeBean;

@RestController
public class BasicController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/welcome")
	public String welcome() {
		return "Hello World";
	}

	@GetMapping("/welcome-with-object")
	public WelcomeBean welcomeWithObject() {
		return new WelcomeBean("Hello World");
	}

	private static final String helloWorldTemplate = "Hello World, %s!";

	@GetMapping("/welcome-with-parameter/name/{name}")
	public WelcomeBean welcomeWithParameter(@PathVariable String name) {
		return new WelcomeBean(String.format(helloWorldTemplate, name));
	}

	@GetMapping("/welcome-internationalized")
	public String msg(@RequestHeader(value = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("welcome.message", null, locale);
	}
}