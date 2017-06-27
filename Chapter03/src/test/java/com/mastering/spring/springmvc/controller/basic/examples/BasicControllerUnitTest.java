package com.mastering.spring.springmvc.controller.basic.examples;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mastering.spring.springmvc.controller.basic.examples.BasicController;

public class BasicControllerUnitTest {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new BasicController())
				.build();
	}

	@Test
	public void getAccount() throws Exception {
		this.mockMvc
				.perform(
						get("/welcome")
								.accept(MediaType
										.parseMediaType("application/html;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType("application/html;charset=UTF-8"))
				.andExpect(content().string("Welcome to Spring MVC"));
	}

}