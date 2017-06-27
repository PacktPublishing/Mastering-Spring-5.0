package com.mastering.spring.springmvc.controller.basic.examples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicViewController {
	@RequestMapping(value = "/welcome-view")
	public String welcome() {
		return "welcome";
	}
}
