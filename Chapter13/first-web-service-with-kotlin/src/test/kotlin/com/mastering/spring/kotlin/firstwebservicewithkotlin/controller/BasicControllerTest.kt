package com.mastering.spring.kotlin.firstwebservicewithkotlin.controller

import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@WebMvcTest(BasicController::class)
class BasicControllerTest {

	@Autowired
	lateinit var mvc: MockMvc;

	@Test
	fun `GET welcome returns "Hello World"`() {
		mvc.perform(
				MockMvcRequestBuilders.get("/welcome").accept(
						MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
	}


	@Test
	fun `GET welcome-with-object returns "Hello World"`() {

		mvc.perform(
				MockMvcRequestBuilders.get("/welcome-with-object").accept(
						MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello World")));
	}


	@Test
	fun `GET welcome-with-parameter returns "Hello World, Buddy"`() {

		mvc.perform(
				MockMvcRequestBuilders.get("/welcome-with-parameter/name/Buddy").accept(
						MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello World, Buddy")));
	}

}