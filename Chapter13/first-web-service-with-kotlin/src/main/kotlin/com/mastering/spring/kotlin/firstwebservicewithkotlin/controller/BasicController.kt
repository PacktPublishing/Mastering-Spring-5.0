package com.mastering.spring.kotlin.firstwebservicewithkotlin.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import com.mastering.spring.kotlin.firstwebservicewithkotlin.bean.WelcomeBean
import org.springframework.web.bind.annotation.PathVariable

@RestController
class BasicController {
	@GetMapping("/welcome")
	fun welcome() = "Hello World"

	@GetMapping("/welcome-with-object")
	fun welcomeWithObject() = WelcomeBean("Hello World")

	@GetMapping("/welcome-with-parameter/name/{name}")
	fun welcomeWithParameter(@PathVariable name: String) = WelcomeBean("Hello World, $name")
}