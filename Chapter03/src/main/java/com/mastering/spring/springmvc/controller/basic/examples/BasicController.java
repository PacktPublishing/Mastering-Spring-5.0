package com.mastering.spring.springmvc.controller.basic.examples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
	@RequestMapping(value = "/welcome")
	@ResponseBody
	public String welcome() {
		return "Welcome to Spring MVC";
	}
}
