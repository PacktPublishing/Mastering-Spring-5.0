package com.mastering.spring.springmvc.controller.basic.examples;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/user-servlet.xml")
public class BasicControllerSpringConfigurationUnitTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
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